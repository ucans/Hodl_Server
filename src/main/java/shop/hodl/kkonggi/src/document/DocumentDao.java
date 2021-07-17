package shop.hodl.kkonggi.src.document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import shop.hodl.kkonggi.src.document.model.GetBoardRes;
import shop.hodl.kkonggi.src.document.model.GetBoradContentRes;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DocumentDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<GetBoardRes> getBoardList(){
        String getBoradQuery = "select noticeIdx, title, if(status = 'L', 1, 0) as isNew, date_format(createAt, '%Y.%m.%d') as date from NoticeBoard where status != 'N' order by  isNew desc , createAt desc";

        return this.jdbcTemplate.query(getBoradQuery,
                ((rs, rowNum) -> new GetBoardRes(
                        rs.getInt("noticeIdx"),
                        rs.getString("title"),
                        rs.getString("date"),
                        rs.getInt("isNew")
                )));
    }

    public GetBoradContentRes getBoradContent(int noticeboardIdx){
        String getBoradContentQuery = "select title, if(status = 'L', 1, 0) as isNew, date_format(createAt, '%Y.%m.%d') as date, content from NoticeBoard where status != 'N' and noticeIdx = ?";
        return this.jdbcTemplate.queryForObject(getBoradContentQuery,
                (rs, rowNum) -> new GetBoradContentRes(
                        rs.getString("title"),
                        rs.getInt("isNew"),
                        rs.getString("date"),
                        rs.getString("content")
                ), noticeboardIdx);
    }

    public int checkBoard(int noticeboardIdx){
        String checkQuery = "select(exists(select noticeIdx from NoticeBoard where noticeIdx = ?))";
        return this.jdbcTemplate.queryForObject(checkQuery, int.class, noticeboardIdx);
    }

}

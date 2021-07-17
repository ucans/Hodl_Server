package shop.hodl.kkonggi.src.record.medicine.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PatchMedicineRecordReq {
    private String date;    // 날짜
    private double amount;  // 투약량 (디폴트 1)
    private String time;    // HH:ss
    private String memo;
}

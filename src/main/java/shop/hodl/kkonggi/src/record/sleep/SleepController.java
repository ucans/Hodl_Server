package shop.hodl.kkonggi.src.record.sleep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.hodl.kkonggi.config.BaseException;
import shop.hodl.kkonggi.config.BaseResponse;
import shop.hodl.kkonggi.config.BaseResponseStatus;
import shop.hodl.kkonggi.src.record.sleep.model.GetSleepRes;
import shop.hodl.kkonggi.src.user.model.GetChatRes;
import shop.hodl.kkonggi.utils.JwtService;

@RestController
@RequestMapping("/app/v1/users/record/sleep")
public class SleepController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final SleepProvider sleepProvider;
    @Autowired
    private final SleepService sleepService;
    @Autowired
    private final JwtService jwtService;
    private static final int scenarioIdx = 5;

    public SleepController(SleepProvider sleepProvider, SleepService sleepService, JwtService jwtService){
        this.sleepProvider = sleepProvider;
        this.sleepService = sleepService;
        this.jwtService = jwtService;
    }

    /**
     * 수면 기록할래 클릭
     * @return
     */
    @ResponseBody
    @GetMapping("/input")
    public BaseResponse<GetChatRes> getSleepInput(){
        try{
            int userIdx = jwtService.getUserIdx();
            String groupId = "SLEEP_REC_INPUT";
            GetChatRes getChatRes = sleepProvider.getSleepInput(userIdx, scenarioIdx, groupId);
            return new BaseResponse<>(getChatRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

    /**
     * 수면 기록 페이지 get
     */
    @ResponseBody
    @GetMapping("")
    public BaseResponse<GetSleepRes> getSleep(@RequestParam(required = false) String date){
        try{
            int userIdx = jwtService.getUserIdx();
            GetSleepRes getSleepRes = sleepProvider.getSleep(userIdx, date);
            return new BaseResponse<>(getSleepRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }

}

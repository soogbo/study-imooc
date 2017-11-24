package shisp.rocketmq.mq.productconsumer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testMq")
public class ShispTestMqController {

    @Autowired
    private SubmitTestMqProducer submitTestMqProducer;

    @GetMapping(value = "/submitTestMqProducer")
    public String submitTestMqProducer() {
        List<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 1,2,3,4,5,6);
        
        try {
            submitTestMqProducer.sendOperationToMq(arrayList);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}

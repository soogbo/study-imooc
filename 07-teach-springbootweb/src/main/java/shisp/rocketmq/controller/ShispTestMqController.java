package shisp.rocketmq.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shisp.rocketmq.service.SubmitTestMqProducer;
import shisp.utils.ServiceException;

/**
 * 页面调用发送mq测试Controller
 * Created by shisp on 2017年11月24日.
 */
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
//            int i = 1/0;
//            System.out.println(i);
            return "success";
        } catch (Exception e) {
            return "fail";
//            throw new ServiceException(1, "发送mq测试异常");
        }
    }
}

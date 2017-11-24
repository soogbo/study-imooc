package shisp.rocketmq.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shisp.rocketmq.service.SubmitTestMqProducer;
import shisp.utils.ResponseResult;
import shisp.utils.RestResultUtil;

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
    public ResponseResult<?> submitTestMqProducer() {
        List<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 1,2,3,4,5,6);
        
        try {
            submitTestMqProducer.sendOperationToMq(arrayList);
            return RestResultUtil.success(ResponseResult.newInstance(0, null, arrayList));
        } catch (Exception e) {
            return RestResultUtil.error(1, "fail");
//            throw new ServiceException(1, "发送mq测试异常");
        }
    }
}

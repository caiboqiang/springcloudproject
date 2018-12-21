package com.cai.client.feign;

import com.cai.common.MessageBox;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 使用Feign通信
 */
@RestController
public class FeignConrtoller {

    @Autowired
    private Feign feign;

    @GetMapping("/getFeign")
    public MessageBox getFeign(){
        String data = feign.getF();
        JSONObject jsonObject = JSONObject.fromObject(data);
        String dataJson = jsonObject.getString("data");
        return MessageBox.build("100","ok Json",dataJson);
    }

    /**
     * 传参 对象等都要分开指定
     * @return
     */
    @GetMapping("/getPhones")
    public MessageBox getPhone(){
        String data = feign.getP("13971320964");
        JSONObject jsonObject = JSONObject.fromObject(data);
        String dataJson = jsonObject.getString("data");
        return MessageBox.build("100","ok Json",dataJson);
    }

}

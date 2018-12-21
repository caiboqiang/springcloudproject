package com.cai.serviceController;



import com.cai.common.MessageBox;
import com.cai.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试类  被调用方
 */
@RestController
public class ServiceUserInfoController {
    //todo module
    @Autowired
    private UserInfoService userService;
    @GetMapping("userHello")
    public MessageBox userInfoControllerHello(){
        return MessageBox.build("100","0.0.1 OK");
    }

    @GetMapping("getAll")
    public MessageBox getAll(){
        return MessageBox.build("100","ok",userService.get());
    }

    @RequestMapping("/getPhone")
    public MessageBox getName(String userPhone){
        System.out.print(userPhone);
        return MessageBox.build("100","ok",userService.getName(userPhone));
    }
}

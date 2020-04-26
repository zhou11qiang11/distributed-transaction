package cn.zq.controller;

import cn.zq.service.LocalGamePayService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GameController {

    @Resource
    private LocalGamePayService localGamePayService;

    @PostMapping("/game")
    public Map game(Integer userId, Double amount){
        Map map = new HashMap();
        try{
          localGamePayService.game(userId, amount);
            map.put("result",true);
        }catch (Exception e){
            e.printStackTrace();
            map.put("result",false);
        }
        return map;
    }
}

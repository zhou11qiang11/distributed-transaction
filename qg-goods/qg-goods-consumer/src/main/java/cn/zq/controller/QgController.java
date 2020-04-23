package cn.zq.controller;

import cn.zq.service.LocalQgGoodsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class QgController {

    @Resource
    private LocalQgGoodsService qgGoodsService;

    /**
     * 抢购
     */
    @PostMapping("/qg")
    public Map qg(String userId, String goodsId, Integer num) {
        Map map = new HashMap();
        try {
            qgGoodsService.qg(userId, goodsId, num);
            map.put("result", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result", false);
        }
        return map;
    }


}

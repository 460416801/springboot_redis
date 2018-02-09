package com.lzx.Controller;

import com.lzx.Config.APIResult;
import com.lzx.Config.BaseAPI;
import com.lzx.Config.ResultCode;
import com.lzx.Service.MateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ronin on 2018/2/9.
 */
@RestController
public class MateController extends BaseAPI{

    @Autowired
    private MateService mateService;

    @GetMapping("lala")
    public APIResult lala(@RequestParam("name")String name,@RequestParam("age")Integer age){
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("data", mateService.lala(name, age));
            return this.setResult(ResultCode.SUCCESS,map);
        }catch(Exception e){
            return this.setResult(ResultCode.ERROR,e.getLocalizedMessage());
        }
    }

    @GetMapping("findAll")
    public APIResult findAll(){
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("data", mateService.findAll());
            return this.setResult(ResultCode.SUCCESS,map);
        }catch(Exception e){
            return this.setResult(ResultCode.ERROR,e.getLocalizedMessage());
        }
    }
}

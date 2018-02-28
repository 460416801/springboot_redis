package com.lzx.Controller;

import com.lzx.Config.APIResult;
import com.lzx.Config.BaseAPI;
import com.lzx.Config.ResultCode;
import com.lzx.Service.MateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController
public class MateController extends BaseAPI {

    @Autowired
    private MateService mateService;

    @GetMapping("/findById/{id}")
    public APIResult findById(@PathVariable("id") int id) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("data", mateService.findById(id));
            return this.setResult(ResultCode.SUCCESS, map);
        } catch (Exception e) {
            return this.setResult(ResultCode.ERROR, e.getLocalizedMessage());
        }
    }

    @GetMapping("findAll")
    public APIResult findAll() {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("data", mateService.findAll());
            return this.setResult(ResultCode.SUCCESS, map);
        } catch (Exception e) {
            return this.setResult(ResultCode.ERROR, e.getLocalizedMessage());
        }
    }


    @PostMapping("insert")
    public APIResult insert() {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("data", mateService.insert(888, "李正旭", 22, new Date()));
            return this.setResult(ResultCode.SUCCESS, map);
        } catch (Exception e) {
            return this.setResult(ResultCode.ERROR, e.getLocalizedMessage());
        }
    }


    @PutMapping("update")
    public APIResult update() {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            mateService.update(999, "李正旭", 22, new Date());
            map.put("data", "修改成功，已做缓存处理");
            return this.setResult(ResultCode.SUCCESS, map);
        } catch (Exception e) {
            return this.setResult(ResultCode.ERROR, e.getLocalizedMessage());
        }
    }

    @DeleteMapping("delete/{id}")
    public APIResult delete(@PathVariable("id") int id) {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            mateService.delete(id);
            map.put("data", "修改成功，已做缓存处理");
            return this.setResult(ResultCode.SUCCESS, map);
        } catch (Exception e) {
            return this.setResult(ResultCode.ERROR, e.getLocalizedMessage());
        }
    }

}

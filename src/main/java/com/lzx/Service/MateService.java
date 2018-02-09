package com.lzx.Service;

import com.lzx.Dao.MateMapper;
import com.lzx.Entity.Mate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ronin on 2018/2/9.
 */
@Service
@CacheConfig(cacheNames = "users")
public class MateService {

    @Autowired
    private MateMapper mateMapper;


    public List<Mate> lala (String name ,Integer age){
        return mateMapper.lala(name,age);
    }

    @Cacheable
    public List<Mate> findAll (){
        return mateMapper.findAll();
    }
}

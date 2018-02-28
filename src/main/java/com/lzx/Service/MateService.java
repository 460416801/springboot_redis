package com.lzx.Service;

import com.lzx.Dao.MateMapper;
import com.lzx.Entity.Mate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

/**
 * Created by Ronin on 2018/2/9.
 */
@Service
public class MateService {

    @Autowired
    private MateMapper mateMapper;

    public List<Mate> findById(int id) {
        return mateMapper.findById(id);
    }

    public List<Mate> findAll() {
        return mateMapper.findAll();
    }


    public int insert(int id,String name,int age,Date brithday) {
        int insert = mateMapper.insert(id, name, age, brithday);
        mateMapper.findAllPut();
        return insert;
    }

    public void update(int id,String name,int age,Date brithday) {
        mateMapper.update(id, name, age, brithday);
        mateMapper.findAllPut();
    }

    public void delete(int id) {
        mateMapper.delete(id);
        mateMapper.findAllPut();
    }

}

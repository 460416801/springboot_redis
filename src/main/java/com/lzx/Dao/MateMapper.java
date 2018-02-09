package com.lzx.Dao;

import com.lzx.Entity.Mate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Ronin on 2018/2/9.
 */
public interface MateMapper {

    List<Mate> lala(@Param("name")String name ,@Param("age")Integer age);

    List<Mate> findAll();


}

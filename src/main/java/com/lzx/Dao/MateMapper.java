package com.lzx.Dao;

import com.lzx.Entity.Mate;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.Date;
import java.util.List;

/**
 * Created by Ronin on 2018/2/9.
 *                        --学习不停歇
 *
 * 将缓存的逻辑写在mapper层，使用@CacheConfig来设置缓存的名称，
 * 使用(cacheNames = "mates")就可以不用在每个方法上缓存@Cacheable里面写上value值了，spring4的新特性
 *
 *
 * @Cacheable(key = "'findAll'") 这个是指将方法的返回值放进redis中，key就是“findAll” value就是方法的返回值
 * @CachePut(key = "'findAll'")  这个是指将方法重新执行，将把数据库查询的最新的数据更新到redis缓存中去
 * 这样的话当第一次调用这个方法，我们回去查询数据库，把数据放到redis缓存中，下次再调用这个方法都不会去访问数据库，而是直接访问redis
 * 缓存，这样就可以减轻数据库的压力，要把不经常改变的、经常查询的数据使用redis缓存
 *
 *
 *
 *
 * @Cacheable(key = "#p0") 这个是指将方法的返回值放进redis中，key就是传入的第一个参数。也就是id， value就是方法的返回值
 * @CachePut(key = "#p0") 这个方法是无返回值的。因为是根据传入的第一个参数也就是id来更新数据，并把更新的数据更新到redis缓存中
 * @CacheEvict(key = "#p0") 这个方法是无返回值的。因为是根据传入的第一个参数也就是id来删除数据，并把删除后的数据更新到redis缓存中
 */
@CacheConfig(cacheNames = "mates")
public interface MateMapper {

    @Cacheable(key = "#p0")
    List<Mate> findById(@Param("id")int id);

    @Cacheable(key = "'findAll'")
    List<Mate> findAll();

    @CachePut(key = "'findAll'")
    List<Mate> findAllPut();

    int insert(@Param("id")int id,@Param("name")String name,@Param("age")int age,@Param("brithday")Date brithday);

    @CachePut(key = "#p0")
    void update(@Param("id")int id,@Param("name")String name,@Param("age")int age,@Param("brithday")Date brithday);

    @CacheEvict(key = "#p0")
    void delete(@Param("id")int id);


}

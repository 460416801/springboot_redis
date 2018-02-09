package com.lzx.Config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;

/**
 * Created by Ronin on 2018/2/9.
 *
 * @Configuration 注解表示这个类是一个配置类
 * @EnableCaching 注解来开启我们的项目支持缓存，
 * 我们在配置类内添加了方法cacheManager()，
 * 方法的返回值则是使用了我们的Redis缓存的管理器，
 * SpringBoot项目启动时就会去找自定义配置的CacheManager对象并且自动应用到项目中。
 *
 *
 * 在需要缓存的数据的类名上面添加@CacheConfig(cacheNames = "users")注解。括号里面的是自定义名称
 * 在需要缓存的数据的方法上面添加@Cacheable 注解
 *
 */
@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        return new RedisCacheManager(redisTemplate);
    }

    /**
     * 因为自动生成的key很难看懂，所以我们自定义一个方法生成key值
     *
     * @return
     */
    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                //格式化缓存key字符串
                StringBuilder sb = new StringBuilder();
                //追加类名
                sb.append(o.getClass().getName());
                //追加方法名
                sb.append(method.getName());
                //遍历参数并追加
                for (Object obj : objects) {
                    sb.append(obj.toString());
                }
                System.out.println("调用Redis缓存Key:" + sb.toString());
                return sb.toString();
            }
        };
    }
}

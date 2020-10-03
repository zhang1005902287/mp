package com.zsq.mp.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsq.mp.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {


    @Caching
    @Cacheable(cacheNames = {"123"})
    public User getUser(@Param("id") Integer id);
}

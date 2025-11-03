package com.felix.service;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.springframework.beans.factory.annotation.Autowired;

public class DataOpServiceImpl<T> implements DataOpService<T> {

    @Autowired
    private BaseMapper<T> baseMapper;

    @Override
    public boolean save(T t) {
        return SqlHelper.retBool(baseMapper.insert(t));
    }

}

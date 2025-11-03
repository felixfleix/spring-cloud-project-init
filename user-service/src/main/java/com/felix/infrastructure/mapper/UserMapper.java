package com.felix.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.felix.domain.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserInfo> {

}

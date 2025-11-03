package com.felix.domain.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.felix.domain.entity.UserInfo;
import com.felix.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, UserInfo> {



}

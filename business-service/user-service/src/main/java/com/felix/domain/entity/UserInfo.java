package com.felix.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Getter
@Setter
@TableName(value = "user_info")
public class UserInfo extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;

    private Integer age;

}

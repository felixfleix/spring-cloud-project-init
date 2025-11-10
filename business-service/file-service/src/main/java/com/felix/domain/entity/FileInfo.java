package com.felix.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

@Getter
@Setter
@TableName(value = "file_info")
public class FileInfo extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1;

    private String fileName;

    private String contentType;

    private Long fileSize;

    private String storePath;

    private String fileSuffix;

    private String nickName;


}

package com.felix.domain.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.felix.domain.entity.FileInfo;
import com.felix.infrastructure.mapper.FileInfoMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService extends ServiceImpl<FileInfoMapper, FileInfo> {

    public boolean upload(MultipartFile file) {
        return true;
    }

    public void download(String fileName) {

    }

}

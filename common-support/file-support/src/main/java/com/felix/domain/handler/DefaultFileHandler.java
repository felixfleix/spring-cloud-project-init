package com.felix.domain.handler;

import com.felix.domain.bean.FileType;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

public class DefaultFileHandler extends AbstractFileHandler {

    public DefaultFileHandler(MultipartFile multipartFile) {
        super(multipartFile);
    }

    @Override
    protected List<String> getPermitFileTypes() {
        return Arrays.stream(FileType.values()).map(FileType::getCode).toList();
    }
}

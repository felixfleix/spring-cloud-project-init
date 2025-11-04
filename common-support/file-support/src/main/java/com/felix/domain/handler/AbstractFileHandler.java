package com.felix.domain.handler;

import com.felix.domain.FileOperator;
import com.felix.domain.FileVerifiable;
import com.felix.domain.exception.FileContentObtainException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

public abstract class AbstractFileHandler implements FileVerifiable, FileOperator {

    private final MultipartFile multipartFile;

    private final String name;
    private final String type;
    private final long size;
    private final byte[] bytes;
    private final InputStream inputStream;
    private final String path;

    private long limitSizeForSingle;

    private static final long defaultLimitSizeForSingle = 1 << 20;
    private static final String defaultPath = "/tmp";

    public AbstractFileHandler(MultipartFile multipartFile) {
        this(multipartFile, defaultLimitSizeForSingle, defaultPath);
    }

    public AbstractFileHandler(MultipartFile multipartFile, long limitSizeForSingle, String path) {
        this.multipartFile = multipartFile;
        this.limitSizeForSingle = limitSizeForSingle;

        multipartFile.getName();
        this.name = multipartFile.getName().isBlank()
                ? multipartFile.getOriginalFilename() : multipartFile.getName();
        this.type = multipartFile.getContentType();
        this.size = multipartFile.getSize();

        this.path = path == null || path.isBlank() ? defaultPath : path;

        try {
            this.bytes = multipartFile.getBytes();
        } catch (IOException e) {
            throw new FileContentObtainException(null, e);
        }

        try {
            this.inputStream = multipartFile.getInputStream();
        } catch (IOException e) {
            throw new FileContentObtainException(null, e);
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getContentType() {
        return this.type;
    }

    @Override
    public long getSize() {
        return this.size;
    }

    @Override
    public String transferTo() throws IOException {
        String fileNameBySystem = UUID.randomUUID().toString();
        this.multipartFile.transferTo(Paths.get(this.path, fileNameBySystem));
        return fileNameBySystem;
    }

    public boolean verifyFileType() {
        if (this.type == null || this.type.isBlank()) {
            return false;
        }
        return getPermitFileTypes().contains(this.type.toLowerCase());
    }

    public boolean verifyFileSize() {
        return this.size > this.limitSizeForSingle;
    }

    protected abstract List<String> getPermitFileTypes();

}

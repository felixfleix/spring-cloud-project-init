package com.felix.controller;

import com.felix.domain.constant.FileType;
import com.felix.domain.handler.DefaultFileHandler;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping(path = "/file")
public class FileController {

    @PostMapping(path = "/upload")
    @ResponseBody
    public void upload(@RequestParam(name = "file") MultipartFile file) {
        System.out.println("file.getName: " + file.getName());
        System.out.println("file.getOriginalFilename: " + file.getOriginalFilename());
        System.out.println("file.getContentType: " + file.getContentType());
        DefaultFileHandler defaultFileHandler = new DefaultFileHandler(file);
        try {
            defaultFileHandler.transferTo();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping(path = "/multiUpload")
    @ResponseBody
    public void multiUpload(@RequestParam(name = "files") MultipartFile[] files) {
        for (MultipartFile file : files) {
            try {
                new DefaultFileHandler(file).transferTo();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @GetMapping(path = "/download/{fileName}")
    public void download(@PathVariable(name = "fileName") String fileName, HttpServletResponse response) {
        File file = new File("/tmp/" + fileName);
        if (!file.exists()) {
            throw new RuntimeException();
        }

        response.setContentType(FileType.APPLICATION_OCTET_STREAM.getCode());
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            ServletOutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
                outputStream.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(path = "/upload")
    public String upload() {
        return "upload";
    }

    @GetMapping(path = "/multiUpload")
    public String multiUpload() {
        return "uploadMulti";
    }

}

package com.felix.domain.bean;

public enum FileType {

    TEXT_PLAIN("text/plain","纯文本格式"),
    TEXT_HTML("text/html","HTML 格式"),
    TEXT_XML("text/xml","XML 格式"),
    IMG_GIF("image/gif","GIF 图片格式"),
    IMG_JPEG("image/jpeg","JPG 图片格式"),
    IMG_PNG("image/png","PNG 图片格式"),
    APPLICATION_XHTML_XML("application/xhtml+xml","XHTML 格式"),
    APPLICATION_XML("application/xml","XML 数据格式"),
    APPLICATION_ATOM_XML("application/atom+xml","Atom XML 聚合格式"),
    APPLICATION_JSON("application/json","JSON 数据格式"),
    APPLICATION_OCTET_STREAM("application/octet-stream","二进制流数据（如常见的文件下载）"),
    APPLICATION_PDF("application/pdf","PDF 格式"),
    APPLICATION_ZIP("application/zip","ZIP 包格式"),
    APPLICATION_MSWORD("application/msword"," Word 文档格式"),
    APPLICATION_X_WWW_FORM_URLENCODED("application/x-www-form-urlencoded","表单数据被编码为 key/value 格式发送到服务器（表单默认的提交数据的格式）"),
    ;

    private final String code;

    private final String description;

    FileType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}

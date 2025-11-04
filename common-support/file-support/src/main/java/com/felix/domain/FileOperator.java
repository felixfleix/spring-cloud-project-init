package com.felix.domain;

import java.io.IOException;

public interface FileOperator {

    String getName();

    String getContentType();

    long getSize();

    String transferTo() throws IOException;
}

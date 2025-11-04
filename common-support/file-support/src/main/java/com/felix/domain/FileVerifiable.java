package com.felix.domain;

public interface FileVerifiable {

    default boolean verifyFileName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    boolean verifyFileType();

    boolean verifyFileSize();

    default boolean verifyFileContent() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

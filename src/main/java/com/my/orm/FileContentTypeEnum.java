package com.my.orm;

public enum FileContentTypeEnum {
    CSV(".+\\.csv"),
    XML(".+\\.xml"),
    JSON(".+\\.json");

    private String pattern;

    FileContentTypeEnum(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}

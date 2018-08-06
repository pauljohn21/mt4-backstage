package com.kajie88.base.enums.common;

public enum TerminalType {

    ANDROID("android", "android"),
    IOS("ios", "ios"),
    WEB("web", "web"),
    WAP("wap", "wap");

    TerminalType(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static TerminalType getExamType(String value) {
        for (TerminalType examType : TerminalType.values()) {
            if (value.equals(examType.getValue())) {
                return examType;
            }
        }
        return null;
    }

    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
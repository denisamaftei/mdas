package com.mdas.demo.util;

public class Constants {
    public static final String EMAIL_REGEX = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$";
    public static final String CONTAINS_NUMBER_REGEX = "[0-9]+";
    public static final String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";

}

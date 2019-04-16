package com.example.informaltest.data.http.local;

import com.example.informaltest.MyApplication;

import java.io.File;

public class HttpConstant {

    public static final String PATH_DATA = MyApplication.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + File.separator + "NetCache";

    public final static String BASE_URL = "218.6.69.201:18999";
}

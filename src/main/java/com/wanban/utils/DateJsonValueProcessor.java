package com.wanban.utils;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * Created by CHLaih on 2018/1/22.
 */
public class DateJsonValueProcessor implements JsonValueProcessor {
    private String format = "yyyy-MM-dd HH:mm:ss";
    public DateJsonValueProcessor() {

    }

    public DateJsonValueProcessor(String format) {
        this.format = format;
    }

    @Override
    public Object processArrayValue(Object o, JsonConfig jsonConfig) {
        return null;
    }

    @Override
    public Object processObjectValue(String s, Object o, JsonConfig jsonConfig) {
        return null;
    }
}

package com.wanban.utils;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by CHLaih on 2018/1/23.
 */
public class DateJsonValueProcessor implements JsonValueProcessor {

    private String format = "yyyy年MM月dd日 HH时mm分ss秒";

    private SimpleDateFormat sdf = new SimpleDateFormat(format);

    @Override
    public Object processArrayValue(Object o, JsonConfig jsonConfig) {
         return this.process(o);
    }

    @Override
    public Object processObjectValue(String s, Object o, JsonConfig jsonConfig) {
        return this.process(o);
    }

    //处理Date类型返回的Json数值

    private Object process(Object value) {

        if(value == null) {

            return"";

        }else if (value instanceof Date)
            return sdf.format((Date) value);
        else{
            return value.toString();

        }

    }
}

package com.mds.vo;

/**
 * Created with IntelliJ IDEA.
 * User: T5S
 * Date: 17-10-22
 * Time: 下午2:01
 * To change this template use File | Settings | File Templates.
 */
public class BasicLineChartVo {
    public static final String width3 = "3";
    private String name;
    private String color;
    private String line_width;
    private String [] value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLine_width() {
        return line_width;
    }

    public void setLine_width(String line_width) {
        this.line_width = line_width;
    }

    public String[] getValue() {
        return value;
    }

    public void setValue(String[] value) {
        this.value = value;
    }
}

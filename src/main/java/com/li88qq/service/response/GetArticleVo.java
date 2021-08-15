package com.li88qq.service.response;

/**
 * @author li88qq
 * @version 1.0 2021/8/8 22:16
 */
public class GetArticleVo {

    private String title;//标题
    private Integer open;//是否公开,1-公开
    private Integer original;//是否原创,1-原创
    private String quote;//引用地址
    private String labels;//标签

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOpen() {
        return open;
    }

    public void setOpen(Integer open) {
        this.open = open;
    }

    public Integer getOriginal() {
        return original;
    }

    public void setOriginal(Integer original) {
        this.original = original;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }
}

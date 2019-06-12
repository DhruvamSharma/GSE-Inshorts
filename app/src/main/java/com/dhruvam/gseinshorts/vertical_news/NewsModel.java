package com.dhruvam.gseinshorts.vertical_news;

public class NewsModel {

    private String newsTitle;
    private String newsBody;
    private String newsSource;
    private String newsLink;

    public NewsModel(String newsTitle, String newsBody, String newsSource, String newsLink) {
        this.newsTitle = newsTitle;
        this.newsBody = newsBody;
        this.newsSource = newsSource;
        this.newsLink = newsLink;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsBody() {
        return newsBody;
    }

    public void setNewsBody(String newsBody) {
        this.newsBody = newsBody;
    }

    public String getNewsSource() {
        return newsSource;
    }

    public void setNewsSource(String newsSource) {
        this.newsSource = newsSource;
    }

    public String getNewsLink() {
        return newsLink;
    }

    public void setNewsLink(String newsLink) {
        this.newsLink = newsLink;
    }
}

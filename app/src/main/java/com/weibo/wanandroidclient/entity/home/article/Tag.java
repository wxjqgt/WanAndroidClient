package com.weibo.wanandroidclient.entity.home.article;

public class Tag {
    /**
     * name	"项目"
     * url	"/project/list/1?cid=357"
     */
    public String name;
    public String url;

    public Tag(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

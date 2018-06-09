package com.weibo.wanandroidclient.entity.home.banner;

import java.util.List;

public class Banner {

    private List<Data> data;
    private int errorcode;
    private String errormsg;

    public Banner(List<Data> data, int errorcode, String errormsg) {
        this.data = data;
        this.errorcode = errorcode;
        this.errormsg = errormsg;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "data=" + data +
                ", errorcode=" + errorcode +
                ", errormsg='" + errormsg + '\'' +
                '}';
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public List<Data> getData() {
        return data;
    }


    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public int getErrorcode() {
        return errorcode;
    }


    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public static class Data {

        private String desc;
        private int id;
        private String imagePath;
        private int isvisible;
        private int order;
        private String title;
        private int type;
        private String url;

        public Data(String desc, int id, String imagePath, int isvisible, int order, String title, int type, String url) {
            this.desc = desc;
            this.id = id;
            this.imagePath = imagePath;
            this.isvisible = isvisible;
            this.order = order;
            this.title = title;
            this.type = type;
            this.url = url;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "desc='" + desc + '\'' +
                    ", id=" + id +
                    ", imagePath='" + imagePath + '\'' +
                    ", isvisible=" + isvisible +
                    ", order=" + order +
                    ", title='" + title + '\'' +
                    ", type=" + type +
                    ", url='" + url + '\'' +
                    '}';
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }


        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }


        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

        public String getImagePath() {
            return imagePath;
        }


        public void setIsvisible(int isvisible) {
            this.isvisible = isvisible;
        }

        public int getIsvisible() {
            return isvisible;
        }


        public void setOrder(int order) {
            this.order = order;
        }

        public int getOrder() {
            return order;
        }


        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }


        public void setType(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }


        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

    }

}

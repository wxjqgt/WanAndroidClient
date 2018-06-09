package com.weibo.wanandroidclient.entity.home.article;

import java.util.Arrays;

public class DatasItem {
    /**
     * apkLink	""
     * author	"Carson_Ho"
     * chapterId	93
     * chapterName	"基础知识"
     * collect	false
     * courseId	13
     * desc	""
     * envelopePic	""
     * fresh	true
     * id	2937
     * link	"https://www.jianshu.com/p/ca118d704b5e"
     * niceDate	"8小时前"
     * origin	""
     * projectLink	""
     * publishTime	1526805757000
     * superChapterId	134
     * superChapterName	"自定义控件"
     * tags	[]
     * title	"为什么你的自定义View wrap_content不起作用？"
     * type	0
     * userId	-1
     * visible	1
     * zan	0
     */
    public String apkLink;
    public String author;
    public int chapterId;
    public String chapterName;
    public boolean collect;
    public int courseId;
    public String desc;
    public String envelopePic;
    public boolean fresh;
    public int id;
    public String link;
    public  String niceDate;
    public String origin;
    public String projectLink;
    public String publishTime;
    public int superChapterId;
    public String superChapterName;
    public Tag[] tags;
    public String title;
    public int type;
    public int userId;
    public int visible;
    public int zan;

    public DatasItem(String apkLink, String author, int chapterId, String chapterName, boolean collect, int courseId, String desc, String envelopePic, boolean fresh, int id, String link, String niceDate, String origin, String projectLink, String publishTime, int superChapterId, String superChapterName, Tag[] tags, String title, int type, int userId, int visible, int zan) {
        this.apkLink = apkLink;
        this.author = author;
        this.chapterId = chapterId;
        this.chapterName = chapterName;
        this.collect = collect;
        this.courseId = courseId;
        this.desc = desc;
        this.envelopePic = envelopePic;
        this.fresh = fresh;
        this.id = id;
        this.link = link;
        this.niceDate = niceDate;
        this.origin = origin;
        this.projectLink = projectLink;
        this.publishTime = publishTime;
        this.superChapterId = superChapterId;
        this.superChapterName = superChapterName;
        this.tags = tags;
        this.title = title;
        this.type = type;
        this.userId = userId;
        this.visible = visible;
        this.zan = zan;
    }

    @Override
    public String toString() {
        return "DatasItem{" +
                "apkLink='" + apkLink + '\'' +
                ", author='" + author + '\'' +
                ", chapterId=" + chapterId +
                ", chapterName='" + chapterName + '\'' +
                ", collect=" + collect +
                ", courseId=" + courseId +
                ", desc='" + desc + '\'' +
                ", envelopePic='" + envelopePic + '\'' +
                ", fresh=" + fresh +
                ", id=" + id +
                ", link='" + link + '\'' +
                ", niceDate='" + niceDate + '\'' +
                ", origin='" + origin + '\'' +
                ", projectLink='" + projectLink + '\'' +
                ", publishTime='" + publishTime + '\'' +
                ", superChapterId=" + superChapterId +
                ", superChapterName='" + superChapterName + '\'' +
                ", tags=" + Arrays.toString(tags) +
                ", title='" + title + '\'' +
                ", type=" + type +
                ", userId=" + userId +
                ", visible=" + visible +
                ", zan=" + zan +
                '}';
    }

    public String getApkLink() {
        return apkLink;
    }

    public void setApkLink(String apkLink) {
        this.apkLink = apkLink;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public boolean isCollect() {
        return collect;
    }

    public void setCollect(boolean collect) {
        this.collect = collect;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getEnvelopePic() {
        return envelopePic;
    }

    public void setEnvelopePic(String envelopePic) {
        this.envelopePic = envelopePic;
    }

    public boolean isFresh() {
        return fresh;
    }

    public void setFresh(boolean fresh) {
        this.fresh = fresh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNiceDate() {
        return niceDate;
    }

    public void setNiceDate(String niceDate) {
        this.niceDate = niceDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public int getSuperChapterId() {
        return superChapterId;
    }

    public void setSuperChapterId(int superChapterId) {
        this.superChapterId = superChapterId;
    }

    public String getSuperChapterName() {
        return superChapterName;
    }

    public void setSuperChapterName(String superChapterName) {
        this.superChapterName = superChapterName;
    }

    public Tag[] getTags() {
        return tags;
    }

    public void setTags(Tag[] tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public int getZan() {
        return zan;
    }

    public void setZan(int zan) {
        this.zan = zan;
    }
}

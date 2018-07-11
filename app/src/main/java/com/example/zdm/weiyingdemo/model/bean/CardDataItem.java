package com.example.zdm.weiyingdemo.model.bean;

/**
 * author:Created by WeiWeiFeng on 2018/7/10.
 */
public class CardDataItem {
    private String pic;
    private String title;
    private String mediaId;
    private String description;

    public CardDataItem(String pic, String title, String mediaId, String description) {
        this.pic = pic;
        this.title = title;
        this.mediaId = mediaId;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public String toString() {
        return "CardDataItem{" +
                "pic='" + pic + '\'' +
                ", title='" + title + '\'' +
                ", mediaId='" + mediaId + '\'' +
                '}';
    }
}

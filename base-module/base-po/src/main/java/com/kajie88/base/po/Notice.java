package com.kajie88.base.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_notice")
public class Notice {
    @Id
    private Integer id;

    /**
     * 主题
     */
    private String title;

    /**
     * 公告类型
     */
    @Column(name = "notice_type")
    private String noticeType;

    /**
     * 摘要
     */
    @Column(name = "notice_abstract")
    private String noticeAbstract;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "del_flag")
    private Integer delFlag;

    @Column(name = "picture_path")
    private byte[] picturePath;

    @Column(name = "notice_content")
    private String noticeContent;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取主题
     *
     * @return title - 主题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置主题
     *
     * @param title 主题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取公告类型
     *
     * @return notice_type - 公告类型
     */
    public String getNoticeType() {
        return noticeType;
    }

    /**
     * 设置公告类型
     *
     * @param noticeType 公告类型
     */
    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    /**
     * 获取摘要
     *
     * @return notice_abstract - 摘要
     */
    public String getNoticeAbstract() {
        return noticeAbstract;
    }

    /**
     * 设置摘要
     *
     * @param noticeAbstract 摘要
     */
    public void setNoticeAbstract(String noticeAbstract) {
        this.noticeAbstract = noticeAbstract;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return del_flag
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * @param delFlag
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * @return picture_path
     */
    public byte[] getPicturePath() {
        return picturePath;
    }

    /**
     * @param picturePath
     */
    public void setPicturePath(byte[] picturePath) {
        this.picturePath = picturePath;
    }

    /**
     * @return notice_content
     */
    public String getNoticeContent() {
        return noticeContent;
    }

    /**
     * @param noticeContent
     */
    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }
}
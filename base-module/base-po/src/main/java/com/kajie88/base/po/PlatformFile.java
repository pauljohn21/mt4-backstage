package com.kajie88.base.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_file")
public class PlatformFile {
    @Id
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "file_type")
    private String fileType;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "file_class")
    private String fileClass;

    @Column(name = "file_describe")
    private String fileDescribe;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return file_type
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * @param fileType
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * @return file_path
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @return file_class
     */
    public String getFileClass() {
        return fileClass;
    }

    /**
     * @param fileClass
     */
    public void setFileClass(String fileClass) {
        this.fileClass = fileClass;
    }

    /**
     * @return file_describe
     */
    public String getFileDescribe() {
        return fileDescribe;
    }

    /**
     * @param fileDescribe
     */
    public void setFileDescribe(String fileDescribe) {
        this.fileDescribe = fileDescribe;
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
}
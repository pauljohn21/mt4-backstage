package com.kajie88.base.po;

import javax.persistence.*;

@Table(name = "t_dictionary")
public class PlatformDictionary {
    @Id
    private String id;

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
}
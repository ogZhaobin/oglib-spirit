package com.oglib.spirit.boot.cloud.pms.content.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "content_inf")
public class ContentInf implements Serializable {
    private static final long serialVersionUID = 2024295695905117794L;

    /**
     * 主键 自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 标题
     */
    @Column(name = "content_title")
    private String contentTitle;
    /**
     * 内容
     */
    @Column(name = "content")
    private String content;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Long   createTime;

}

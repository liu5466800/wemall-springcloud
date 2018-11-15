package cn.segema.cloud.sso.server.domain;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Resource implements Serializable {

    private Long id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限字符串
     */
    private String code;

    /**
     * 资源类型
     */
    private Integer type;

    /**
     * URL
     */
    private String url;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 父菜单ID
     */
    private Long pid;

}

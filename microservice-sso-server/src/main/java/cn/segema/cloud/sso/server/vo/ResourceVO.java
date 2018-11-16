package cn.segema.cloud.sso.server.vo;

import java.io.Serializable;
import java.math.BigInteger;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResourceVO implements Serializable {

    private BigInteger id;

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
    private BigInteger sort;

    /**
     * 父菜单ID
     */
    private BigInteger pid;

}

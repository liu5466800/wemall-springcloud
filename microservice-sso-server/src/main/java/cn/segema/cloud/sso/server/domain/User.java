package cn.segema.cloud.sso.server.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

import cn.segema.cloud.sso.server.vo.RoleVO;

@Data
@ToString
public class User implements Serializable {

    private Long id;

    /**
     * 用户编号
     */
    private String usercode;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 用户角色
     */
    private List<RoleVO> roleList;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

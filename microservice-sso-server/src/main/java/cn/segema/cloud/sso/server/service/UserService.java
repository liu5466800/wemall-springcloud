package cn.segema.cloud.sso.server.service;


import cn.segema.cloud.sso.server.domain.SysUser;

public interface UserService {

    /**
     * 根据用户名获取系统用户
     */
    SysUser getUserByName(String username);

}

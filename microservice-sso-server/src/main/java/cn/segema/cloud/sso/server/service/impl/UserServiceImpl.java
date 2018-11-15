package cn.segema.cloud.sso.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.segema.cloud.sso.server.repository.UserRepository;
import cn.segema.cloud.sso.server.service.UserService;
import cn.segema.cloud.sso.server.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserVO getUserByName(String username) {
        return userRepository.findByName(username);
    }
}

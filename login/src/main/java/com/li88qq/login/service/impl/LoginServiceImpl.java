package com.li88qq.login.service.impl;

import com.li88qq.bean.beans.system.User;
import com.li88qq.login.dao.system.UserMapper;
import com.li88qq.login.dto.LoginForm;
import com.li88qq.login.dto.LoginVo;
import com.li88qq.login.service.LoginService;
import com.li88qq.publics.session.SessionUtil;
import com.li88qq.publics.session.UserToken;
import com.li88qq.publics.utils.PasswordUtil;
import com.li88qq.publics.web.response.BaseResponse;
import com.li88qq.publics.web.response.ResponseException;
import com.li88qq.publics.web.response.ResponseUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * @author li88qq
 * @version 1.0 2023/12/28 22:35
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserMapper userMapper;

    @Override
    public LoginVo login(LoginForm form) {
        String username = form.getUsername();

        User user = userMapper.findByUsername(username);
        if (user == null) {
            //保存登录记录
            throw new ResponseException("用户名或密码错误");
        }

        // 密码校验
        boolean check = PasswordUtil.checkPassword(form.getPassword(), user.getPassword());
        if (!check) {
            // 保存登录日志
            throw new ResponseException("用户名或密码错误");
        }
        int uid = user.getId();

        UserToken userToken = new UserToken();
        userToken.setUid(uid);
        userToken.setRoleId(user.getRoleId());
        String token = SessionUtil.login(userToken);

        LoginVo vo = new LoginVo();
        vo.setToken(token);
        return vo;
    }

    @Override
    public BaseResponse logout() {
        SessionUtil.logout();

        return ResponseUtil.ok();
    }
}

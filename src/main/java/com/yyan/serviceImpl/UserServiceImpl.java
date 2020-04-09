package com.yyan.serviceImpl;

import com.yyan.dao.UserDao;
import com.yyan.pojo.User;
import com.yyan.service.UserService;
import com.yyan.utils.BaseServiceImpl;
import com.yyan.utils.JwtUtil;
import com.yyan.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void insertUser(User user) {
        user.setPassword(StringUtil.md5Code(user.getPassword())); //对密码进行 md5
        userDao.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public Map login(String email, String pass) {
        String password = StringUtil.md5Code(pass); //对密码进行 md5
        Map map = new HashMap();
        map.put("email", email);
        map.put("password", password);

        User user = userDao.login(map);
        Map resultMap = new HashMap();
        resultMap.put("id", user.getId());
        resultMap.put("name", user.getName());

        // 生成token
        String token = JwtUtil.sign(user.getEmail(), user.getId());
        resultMap.put("token", token);

        return resultMap;
    }
}

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

    /**
     * 注册用户
     *
     * @param user
     */
    @Override
    public void insertUser(User user) {
        user.setPassword(StringUtil.md5Code(user.getPassword())); //对密码进行 md5
        userDao.insertUser(user);
    }

    /**
     * 更新用户密码
     *
     * @param user
     */
    @Override
    public void updateUser(User user) {
        // 用户 id
        String userId = getUserIdToken();
        user.setId(userId);
        user.setPassword(StringUtil.md5Code(user.getPassword())); //对密码进行 md5
        userDao.updateUser(user);
    }

    /**
     * 返回登录人信息
     *
     * @param email
     * @param pass
     * @return
     */
    @Override
    public Map login(String email, String pass) {
        String password = StringUtil.md5Code(pass); //对密码进行 md5
        Map map = new HashMap();
        map.put("email", email);
        map.put("password", password);
        // 通过邮箱查询数据库
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

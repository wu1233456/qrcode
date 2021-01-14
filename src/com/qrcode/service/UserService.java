package com.qrcode.service;

import com.qrcode.bean.User;
import com.qrcode.dao.UserDao;

import java.util.List;

public class UserService {

    UserDao userDao=new UserDao();

    /**
     * 登录
     *
     * @return 如果返回null，说明登录失败，返回有值，是登录成功
     */
    public User get(String username, String password) {
        User res = userDao.get(username,password);
        return res;
    }

    public User get(String username) {
        User res = userDao.get(username);
        return res;
    }

    public User get(Integer id){
        User user = userDao.get(id);
        return user;
    }

    public List<User> getlist(){
        List<User> list = userDao.getlist();
        return list;
    }

    public void save(String username,String password){
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);

        userDao.save(user);
    }

    public void setLocation(Integer id,String location){
        userDao.setlocation(id,location);
    }


}

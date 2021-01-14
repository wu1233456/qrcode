package com.qrcode.dao;

import com.qrcode.bean.User;

import java.util.List;

public class UserDao extends BaseDao{
    public User get(Integer id) {
        String sql = "select * from user where id = ?";
        return queryForOne(User.class, sql, id);
    }

    public User get(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";
        return queryForOne(User.class, sql, username,password);
    }

    public User get(String username) {
        String sql = "select * from user where username = ? ";
        return queryForOne(User.class, sql, username);
    }

    /**
     * 获取全部快递员
     * @return
     */
    public List<User> getlist() {
        String sql = "select * from user where admin=0";
        return queryForList(User.class, sql);
    }

    public int save(User user) {
        String sql = "insert into user(`username`,`password`) values(?,?)";
        return update(sql, user.getUsername(),user.getPassword());
    }

    public int setlocation(Integer id,String location) {
        String sql = "update user set `location` = ? where `id` = ? ";
        return update(sql,location,id);
    }

}

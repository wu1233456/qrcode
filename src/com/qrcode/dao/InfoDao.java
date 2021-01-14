package com.qrcode.dao;

import com.qrcode.bean.Info;
import com.qrcode.bean.User;

import java.util.List;

public class InfoDao extends BaseDao {
    public Info get(Integer id) {
        String sql = "select * from info where id = ?";
        return queryForOne(Info.class, sql, id);
    }


    /**
     * 获取该地区的全部快递
     * @return
     */
    public List<Info> getlist(String location) {
        String sql = "select `id`,`clientname` from info where location = ?";
        return queryForList(Info.class, sql,location);
    }
}

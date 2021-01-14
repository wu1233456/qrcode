package com.qrcode.service;

import com.qrcode.bean.Info;
import com.qrcode.dao.InfoDao;

import javax.security.auth.login.CredentialException;
import java.util.List;

public class InfoService {
    private InfoDao infoDao=new InfoDao();

    public Info get(Integer id){
        Info info = infoDao.get(id);
        return info;
    }

    public List<Info> getlist(String location){
        List<Info> getlist = infoDao.getlist(location);
        return  getlist;
    }
}

package com.qrcode.servlet;

import com.alibaba.fastjson.JSON;
import com.google.zxing.WriterException;
import com.qrcode.bean.Info;
import com.qrcode.bean.User;
import com.qrcode.service.InfoService;
import com.qrcode.service.UserService;
import com.qrcode.utils.QrCodeUtils;
import com.qrcode.utils.ResultBean;
import sun.misc.BASE64Encoder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/info/*")
public class InfoServlet extends BaseServlet {
    private InfoService infoService=new InfoService();
    private UserService userService=new UserService();


    /**
     * 获取二维码的字节码文件,会加密转换成base64传递给前端
     * @param req
     * @param resp
     * @throws IOException
     * @throws WriterException
     */
    public void get(HttpServletRequest req, HttpServletResponse resp) throws IOException, WriterException {
        Integer id = Integer.valueOf(req.getParameter("id"));
        Info info = infoService.get(id);

        String minfo="name:"+info.getClientname()+";address:"+info.getAddress()+";phone:"+info.getPhone();

        byte[] qrCodeImage = QrCodeUtils.getQRCodeImage(minfo, 100, 100);

        BASE64Encoder encoder = new BASE64Encoder();
        String scode = encoder.encode(qrCodeImage);

        Map<String,Object> data=new HashMap<>();
        data.put("code",scode);

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JSON.toJSONString(new ResultBean(data)));
    }

    public void getlist(HttpServletRequest req, HttpServletResponse resp) throws IOException, WriterException{
        //该快递员的id
        Integer id = Integer.valueOf(req.getParameter("id"));
        User user = userService.get(id);

        System.out.println(user);
        List<Info> list = infoService.getlist(user.getLocation());
        Map<String,Object> data=new HashMap<>();
        data.put("list",list);
        System.out.println(list);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JSON.toJSONString(new ResultBean(data)));
    }

}

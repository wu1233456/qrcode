package com.qrcode.servlet;

import com.alibaba.fastjson.JSON;
import com.qrcode.bean.User;
import com.qrcode.eenum.ErrorCodeEnum;
import com.qrcode.service.UserService;
import com.qrcode.utils.ResultBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    private UserService userService=new UserService();

    /**
     * 快递员登录
     * @param req
     * @param resp
     * @throws IOException
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.get(username, password);

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        Map<String,Object> data=new HashMap<>();
        if (user!=null){
            data.put("id",user.getId());
            resp.getWriter().write(JSON.toJSONString(new ResultBean(data)));
        }else {
            resp.getWriter().write(JSON.toJSONString(new ResultBean(ErrorCodeEnum.LOGIN_FAIL)));
        }
    }

    /**
     * 快递员注册
     * @param req
     * @param resp
     * @throws IOException
     */
    public void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username);
        System.out.println(password);

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        User user1 = userService.get(username);
        if (user1!=null){
            resp.getWriter().write(JSON.toJSONString(new ResultBean(ErrorCodeEnum.USER_EXITS)));
        }else {
            userService.save(username,password);
            //从数据库中获取刚刚注册好的用户id并返回回去
            User user = userService.get(username, password);

            Map<String,Object> data=new HashMap<>();
            data.put("id",user.getId());
            resp.getWriter().write(JSON.toJSONString(new ResultBean(data)));
        }
    }

    /**
     * 后台管理员登录
     * @param req
     * @param resp
     * @throws IOException
     */
    public void adminlogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        User user = userService.get(username, password);

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        System.out.println(user);
        if (user==null){
            resp.getWriter().write(JSON.toJSONString(new ResultBean(ErrorCodeEnum.LOGIN_FAIL)));
        }else if (user.getAdmin()==0){
            resp.getWriter().write(JSON.toJSONString(new ResultBean(ErrorCodeEnum.NOT_AUTH)));

        }else {
            Map<String,Object> data=new HashMap<>();
            data.put("id",user.getId());
            resp.getWriter().write(JSON.toJSONString(new ResultBean(data)));
        }
    }


    /**
     * 获取全部快递员
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    public void list(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<User> list = userService.getlist();
        System.out.println(list);

        Map<String,Object> data=new HashMap<>();
        data.put("list",list);
        data.put("totals",list.size());
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JSON.toJSONString(new ResultBean(data)));
    }


    public void setlocation(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        Integer id = Integer.valueOf(req.getParameter("id"));
        String location = req.getParameter("location");

        System.out.println(id);
        System.out.println(location);

        userService.setLocation(id,location);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(JSON.toJSONString(ResultBean.OK));
    }
}

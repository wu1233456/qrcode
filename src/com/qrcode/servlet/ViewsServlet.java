package com.qrcode.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 后台页面跳转
 */
@WebServlet("/admin/*")
public class ViewsServlet extends BaseServlet {

    /**
     * 跳转到登录页面
     * @param req
     * @param resp
     * @throws IOException
     */
    public void login(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/pages/login.jsp").forward(req, resp);
    }


    /**
     * 跳转到管理快递员列表页
     * @param req
     * @param resp
     * @throws IOException
     */
    public void list(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/pages/list.jsp").forward(req, resp);
    }


}

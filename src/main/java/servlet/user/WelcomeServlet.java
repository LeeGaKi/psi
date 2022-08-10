package servlet.user; /**
 * @author:LeeGaki
 * @date:2021/12/19
 */

import dao.UsersMapper;
import dao.impl.UserMapperImpl;
import pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "WelcomeServlet", value = "/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求方式
        String getMethod = request.getMethod();
        request.setAttribute("getMethod",getMethod);
        //客户端浏览器的Locale
        Locale getLocale = request.getLocale();
        request.setAttribute("getLocale",getLocale);
        //获取协议和版本
        String getProtocol = request. getProtocol();
        request.setAttribute("getProtocol", getProtocol);
        //网络连接端口号
        int getLocalPort = request.getLocalPort();
        request.setAttribute("getLocalPort",getLocalPort);
        //获取链接
        String url = request.getRequestURI();
        request.setAttribute("url",url);
        //请求客户端的完整主机名
        String getRemoteHost = request.getRemoteHost();
        request.setAttribute("getRemoteHost",getRemoteHost);
        request.getRequestDispatcher("/welcome.jsp").forward(request,response);
    }
}

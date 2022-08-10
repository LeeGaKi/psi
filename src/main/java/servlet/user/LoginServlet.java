package servlet.user;
/*
 * @author:LeeGaki
 * @date:2021/12/18
 */
import dao.UsersMapper;
import dao.impl.UserMapperImpl;
import pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

/**
 * The type Login servlet.
 * @author LeeGaki
 */
@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String url=null;
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        UsersMapper usersMapper = new UserMapperImpl();
        User user = usersMapper.login(name,pass);
        if (user!=null){
            session.setAttribute("user",user);
            session.setAttribute("loginusername",user.getUsername());
            boolean supper = false;
            User  user1 = usersMapper.UsernameFindSupper(name);
            supper = user1.getSupper();
            if (supper==true){
                url = "/index.jsp";
            }else {
                url ="/index2.jsp";
            }
        }else {
            request.setAttribute("loginmsg","小佳提醒您账号或密码错误");
            url="/login.jsp";
        }
        request.getRequestDispatcher(url).forward(request,response);
    }
}

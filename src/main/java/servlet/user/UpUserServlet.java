package servlet.user; /**
 * @author:LeeGaki
 * @date:2021/12/18
 */

import dao.UsersMapper;
import dao.impl.UserMapperImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpUserServlet", value = "/UpUserServlet")
public class UpUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int id =Integer.parseInt(request.getParameter("id"));
        String pass= request.getParameter("pass");
        UsersMapper usersMapper = new UserMapperImpl();
        System.out.println("pass:"+pass);
        if(pass==""){
            int i =usersMapper.UpPass(id, pass);
            out.println("没有密码也可以登录啦");
        }else {
            int i =usersMapper.UpPass(id,pass);
            out.println("修改成功,<br>请关闭此页面<br>点击右上角刷新按钮");
        }
    }
}

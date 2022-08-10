package servlet.user; /**
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
import java.io.PrintWriter;

@WebServlet(name = "AddUserServlet", value = "/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String iphone = request.getParameter("iphone");
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        User user = new User();
        user.setAddress(address);user.setEmail(email);user.setUsername(username);
        user.setIphone(iphone);user.setPassword(pass);user.setSex(sex);
        UsersMapper usersMapper = new UserMapperImpl();
        int i = usersMapper.addUser(user);
        if (i>0){
            out.println("添加成功,<br><a href=\"/psi/member-add.jsp\">点击继续添加</a>");
        }else {
            out.println("添加失败,笨蛋");
        }
    }
}

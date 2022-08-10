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

@WebServlet(name = "FindOneServlet", value = "/FindOneServlet")
public class FindOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UsersMapper usersMapper = new UserMapperImpl();
        User user = usersMapper.findId(id);
        request.setAttribute("upuser",user);
        request.getRequestDispatcher("/member-password.jsp").forward(request,response);
    }
}

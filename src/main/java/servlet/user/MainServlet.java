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

@WebServlet(name = "MainServlet", value = "/MainServlet")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user1 =(User)session.getAttribute("user");
        int i =  user1.getId();
        UsersMapper usersMapper = new UserMapperImpl();
        User user = usersMapper.findId(i);
        request.setAttribute("mainuser",user);
        String url = "/mainuser.jsp";
        request.getRequestDispatcher(url).forward(request,response);
    }
}

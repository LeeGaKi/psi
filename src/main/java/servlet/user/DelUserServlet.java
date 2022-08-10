package servlet.user; /**
 * @author:LeeGaki
 * @date:2021/12/19
 */

import dao.UsersMapper;
import dao.impl.UserMapperImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DelUserServlet", value = "/DelUserServlet")
public class DelUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UsersMapper usersMapper = new UserMapperImpl();
        int i = usersMapper.delOneUser(id);
        request.getRequestDispatcher("/FindAllUserServlet").forward(request,response);
    }
}

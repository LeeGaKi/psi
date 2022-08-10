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
import java.util.List;

@WebServlet(name = "MhFindServlet", value = "/MhFindServlet")
public class MhFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type =request.getParameter("type");
        UsersMapper usersMapper = new UserMapperImpl();
        String name ="";
        String url =null;
        if(type!=null){
            name = request.getParameter("username");
            url ="/admin-list.jsp";
        }else {
            name = request.getParameter("find-name");
            url = "/member-list.jsp";
        }
        String likename = "%"+name+"%";
        List<User> list = usersMapper.MhFind(likename);
        request.setAttribute("userlist",list);
        request.getRequestDispatcher(url).forward(request,response);
    }
}

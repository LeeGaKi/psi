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
import java.util.List;

@WebServlet(name = "FindAllUserServlet", value = "/FindAllUserServlet")
public class FindAllUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type= request.getParameter("type");
        String url = null;
        String shengji =request.getParameter("shengji");
        if(type!=null){
            url="/admin-list.jsp";
        }else if (shengji!=null){
            url="/admin-add.jsp";
        }else {
            url= "/member-list.jsp";
        }
        UsersMapper usersMapper = new UserMapperImpl();
        List<User> list =usersMapper.findAll();
        request.setAttribute("userlist",list);
        request.getRequestDispatcher(url).forward(request,response);
        }
    }


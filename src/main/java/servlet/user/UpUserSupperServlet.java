package servlet.user; /**
 * @author:LeeGaki
 * @date:2021/12/21
 */

import dao.UsersMapper;
import dao.impl.UserMapperImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpUserSupperServlet", value = "/UpUserSupperServlet")
public class UpUserSupperServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("username");
        Boolean tf = Boolean.valueOf(request.getParameter("supper"));
        UsersMapper usersMapper = new UserMapperImpl();
        int i = usersMapper.upUserSupper(tf,name);
        if (i>0){
            out.println("升级成功,<br><a href=\"/psi/FindAllUserServlet?shengji=1\">点击继续升级</a>");
        }else {
            out.println("升级失败,笨蛋");
        }
    }
}

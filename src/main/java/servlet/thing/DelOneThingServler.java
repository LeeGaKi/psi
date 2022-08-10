package servlet.thing; /**
 * @author:LeeGaki
 * @date:2021/12/22
 */

import dao.ThingsMapper;
import dao.impl.ThingsMapperImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DelOneThingServler", value = "/DelOneThingServler")
public class DelOneThingServler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        ThingsMapper thingsMapper = new ThingsMapperImpl();
        int i = thingsMapper.delOneThing(id);
        request.getRequestDispatcher("/SeacherThingServlet").forward(request,response);
    }
}

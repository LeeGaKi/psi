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

@WebServlet(name = "DelAllThingServlet", value = "/DelAllThingServlet")
public class DelAllThingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ThingsMapper thingsMapper = new ThingsMapperImpl();
        int i = thingsMapper.delAllThing();
        request.getRequestDispatcher("/SeacherThingServlet").forward(request,response);
    }
}

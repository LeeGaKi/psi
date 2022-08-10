package servlet.thing; /**
 * @author:LeeGaki
 * @date:2021/12/23
 */

import dao.ThingsMapper;
import dao.impl.ThingsMapperImpl;
import pojo.Things;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindAllThingKjAddServlet", value = "/FindAllThingKjAddServlet")
public class FindAllThingKjAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ThingsMapper thingsMapper = new ThingsMapperImpl();
        List<Things> thinglist = thingsMapper.findAllThings();
        request.setAttribute("thinglist",thinglist);
        String url = "/order-add.jsp";
        request.getRequestDispatcher(url).forward(request,response);
    }
}

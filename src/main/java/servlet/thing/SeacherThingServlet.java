package servlet.thing; /**
 * @author:LeeGaki
 * @date:2021/12/22
 */

import dao.ThingsMapper;
import dao.impl.ThingsMapperImpl;
import pojo.Things;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SeacherThingServlet", value = "/SeacherThingServlet")
public class SeacherThingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ThingsMapper thingsMapper = new ThingsMapperImpl();
        List<Object> typelist = thingsMapper.SeacherType();
        request.setAttribute("typelist",typelist);
        List<Object> shoplist = thingsMapper.SeacherShop();
        request.setAttribute("shoplist",shoplist);
        List<Things> thinglist = thingsMapper.findAllThings();
        request.setAttribute("thinglist",thinglist);
        request.getRequestDispatcher("/thing-list.jsp").forward(request,response);
    }
}

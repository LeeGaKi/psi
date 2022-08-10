package servlet.thing; /**
 * @author:LeeGaki
 * @date:2021/12/19
 */

import dao.ThingsMapper;
import dao.impl.ThingsMapperImpl;
import pojo.Things;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FindOneThingServlet", value = "/FindOneThingServlet")
public class FindOneThingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ThingsMapper thingsMapper = new ThingsMapperImpl();
        Things thing = thingsMapper.findOne(id);
        if(thing==null){
            request.setAttribute("addThingErr","小7提醒您没有找到您要快捷添加的商品请乖乖去看看id是否正确");
        }else {
            request.setAttribute("thing",thing);
        }
        request.getRequestDispatcher("/order-add.jsp").forward(request,response);
    }
}

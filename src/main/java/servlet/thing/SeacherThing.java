package servlet.thing; /**
 * @author:LeeGaki
 * @date:2021/12/22
 */

import dao.OrderMapper;
import dao.ThingsMapper;
import dao.impl.OrderMapperImpl;
import dao.impl.ThingsMapperImpl;
import pojo.Order;
import pojo.Things;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SeacherThing", value = "/SeacherThing")
public class SeacherThing extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = null;
        String shop=null;
        String name=request.getParameter("thingname");
        String likename = "%"+name+"%";
        String url = "/thing-list.jsp";
        List<Things> list = new ArrayList<>();
        ThingsMapper thingsMapper = new ThingsMapperImpl();
        type = request.getParameter("type");
        shop = request.getParameter("shop");
        if(type==null && shop==null){
            list = thingsMapper.MhFindThing(likename);
        }else {
            list = thingsMapper.seacherThing(type,shop);
        }
        request.setAttribute("thinglist",list);
        List<Object> typelist = thingsMapper.SeacherType();
        request.setAttribute("typelist",typelist);
        List<Object> shoplist = thingsMapper.SeacherShop();
        request.setAttribute("shoplist",shoplist);
        request.getRequestDispatcher(url).forward(request,response);
    }
}

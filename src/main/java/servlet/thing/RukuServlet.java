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

@WebServlet(name = "RukuServlet", value = "/RukuServlet")
public class RukuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ThingsMapper thingsMapper = new ThingsMapperImpl();
        List<Object> list = thingsMapper.findThingname();
        String thingname = request.getParameter("thingname");
        int count = Integer.parseInt(request.getParameter("count"));
        String thingtype = request.getParameter("thingtype");
        int price = Integer.parseInt(request.getParameter("price"));
        String shopping = request.getParameter("shopping");
        int choose  = 0;
        for (Object name : list){
           if (thingname.equals(name)){
                choose=1;
           }
        }
        if(choose==1){
            Things thing = thingsMapper.findOneCount(thingname);
            int i = thing.getCount()+count;
            thingsMapper.upCount(thingname,i);
        }else{
            Things addThing = new Things();
            addThing.setThingname(thingname);
            addThing.setCount(count);
            addThing.setShopping(shopping);
            addThing.setThingtype(thingtype);
            addThing.setPrice(price);
            thingsMapper.addThing(addThing);
        }
        request.getRequestDispatcher("/thing-list.jsp").forward(request,response);
    }
}

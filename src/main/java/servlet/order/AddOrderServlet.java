package servlet.order; /**
 * @author:LeeGaki
 * @date:2021/12/19
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
import java.io.PrintWriter;

@WebServlet(name = "AddOrderServlet", value = "/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Order order = new Order();
        String person=request.getParameter("person");
        order.setPerson(person);
        String iphone=request.getParameter("iphone");
        order.setIphone(iphone);
        String thingname=request.getParameter("thingname");
        order.setThingname(thingname);
        int price=Integer.parseInt(request.getParameter("price"));
        order.setPrice(price);
        OrderMapper orderMapper = new OrderMapperImpl();
        int i = orderMapper.addOrder(order);
        if (i>0){
            out.println("添加成功,<br><a href=\"/psi/FindAllThingKjAddServlet\">点击继续添加点击右上角刷新</a>");
        }else {
            out.println("添加失败,笨蛋");
        }
        }
    }


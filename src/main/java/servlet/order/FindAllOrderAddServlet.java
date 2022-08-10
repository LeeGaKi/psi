package servlet.order; /**
 * @author:LeeGaki
 * @date:2021/12/23
 */

import dao.OrderMapper;
import dao.impl.OrderMapperImpl;
import pojo.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindAllOrderAddServlet", value = "/FindAllOrderAddServlet")
public class FindAllOrderAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderMapper orderMapper = new OrderMapperImpl();
        List<Order> list = orderMapper.findAllOrder();
        request.setAttribute("orderlist",list);
        String url = "/order-add.jsp";
        request.getRequestDispatcher(url).forward(request,response);
    }
}

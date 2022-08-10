package servlet.order; /**
 * @author:LeeGaki
 * @date:2021/12/20
 */

import dao.OrderMapper;
import dao.impl.OrderMapperImpl;
import pojo.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchOrderServlet", value = "/SearchOrderServlet")
public class SearchOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String zhifu = request.getParameter("zhifu");
        OrderMapper orderMapper = new OrderMapperImpl();
        List<Order> orders = orderMapper.searchOrder(zhifu);
        request.setAttribute("orderlist",orders);
        request.getRequestDispatcher("/order-list.jsp").forward(request,response);
        }
    }


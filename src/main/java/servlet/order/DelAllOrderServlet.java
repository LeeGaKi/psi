package servlet.order; /**
 * @author:LeeGaki
 * @date:2021/12/20
 */

import dao.OrderMapper;
import dao.UsersMapper;
import dao.impl.OrderMapperImpl;
import dao.impl.UserMapperImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DelAllOrderServlet", value = "/DelAllOrderServlet")
public class DelAllOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderMapper orderMapper = new OrderMapperImpl();
        int i = orderMapper.delAllOrder();
        request.getRequestDispatcher("/FindAllOrderServlet").forward(request,response);
    }
}

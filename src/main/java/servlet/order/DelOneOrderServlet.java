package servlet.order; /**
 * @author:LeeGaki
 * @date:2021/12/20
 */

import dao.OrderMapper;
import dao.impl.OrderMapperImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DelOneOrderServlet", value = "/DelOneOrderServlet")
public class DelOneOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        OrderMapper orderMapper = new OrderMapperImpl();
        int i = orderMapper.delOneOrder(id);
        request.getRequestDispatcher("/FindAllOrderServlet").forward(request,response);
    }
}

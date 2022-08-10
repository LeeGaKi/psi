package servlet.thing; /**
 * @author:LeeGaki
 * @date:2021/12/22
 */

import dao.ShopsMapper;
import dao.ThingsMapper;
import dao.impl.ShopsMapperImpl;
import dao.impl.ThingsMapperImpl;
import pojo.Shops;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindTypeServlet", value = "/FindTypeServlet")
public class FindTypeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShopsMapper shopsMapper = new ShopsMapperImpl();
        List<Shops> list = shopsMapper.findAllShop();
        request.setAttribute("shoplist",list);
        request.getRequestDispatcher("/thing-add.jsp").forward(request,response);
    }
}

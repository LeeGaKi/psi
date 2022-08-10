package servlet.shop; /**
 * @author:LeeGaki
 * @date:2021/12/22
 */

import dao.ShopsMapper;
import dao.impl.ShopsMapperImpl;
import pojo.Shops;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindAllShopServlet", value = "/FindAllShopServlet")
public class FindAllShopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShopsMapper shopsMapper = new ShopsMapperImpl();
        List<Shops> list = shopsMapper.findAllShop();
        String url = "/shop-list.jsp";
        request.setAttribute("shoplist",list);
        request.getRequestDispatcher(url).forward(request,response);
    }
}

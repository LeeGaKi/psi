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

@WebServlet(name = "MhFindShopServlet", value = "/MhFindShopServlet")
public class MhFindShopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShopsMapper shopsMapper = new ShopsMapperImpl();
        String name = request.getParameter("shopname");
        String likename = "%"+name+"%";
        List<Shops> list = shopsMapper.MhFindShop(likename);
        request.setAttribute("shoplist",list);
        request.getRequestDispatcher("/shop-list.jsp").forward(request,response);
    }
}

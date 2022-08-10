package servlet.shop; /**
 * @author:LeeGaki
 * @date:2021/12/22
 */

import dao.ShopsMapper;
import dao.impl.ShopsMapperImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DelAllShopServlet", value = "/DelAllShopServlet")
public class DelAllShopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ShopsMapper shopsMapper = new ShopsMapperImpl();
        int i = shopsMapper.delAllShop();
        request.getRequestDispatcher("/FindAllShopServlet").forward(request,response);
    }
}

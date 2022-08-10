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
import java.io.PrintWriter;

@WebServlet(name = "AddShopServlet", value = "/AddShopServlet")
public class AddShopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        ShopsMapper shopsMapper = new ShopsMapperImpl();
        Shops shop = new Shops();

        shop.setShopname(request.getParameter("shopname"));
        shop.setPersoniphone(request.getParameter("personiphone"));
        shop.setShopres(request.getParameter("shopres"));
        shop.setShopperson(request.getParameter("shopperson"));
        shop.setShopaddr(request.getParameter("shopaddr"));
        int i =shopsMapper.addShop(shop);
        if (i>0){
            out.println("添加成功,<br><a href=\"/psi/shop-add.jsp\">点击继续添加点击右上角刷新</a>");
        }else {
            out.println("添加失败,笨蛋");
        }
    }
}

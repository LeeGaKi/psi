package dao.impl;

import dao.OrderMapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.Order;
import pojo.Things;
import utils.C3p0Utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:LeeGaki
 * @date:2021/12/19
 */
public class OrderMapperImpl implements OrderMapper {
    QueryRunner runner = new QueryRunner(C3p0Utils.getCon());

    @Override
    public List<Order> searchOrder(String zhifu, String dingdan) {
        String sql ="select * from ljqdb.order where zhifu=? or dingdan=?";
        List<Order> list = new ArrayList<>();
        try {
            list = runner.query(sql,new BeanListHandler<>(Order.class),zhifu,dingdan);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Order> searchOrder(String ordern) {
        String sql ="select * from ljqdb.order where thingname like ?";
        List<Order> list = new ArrayList<>();
        try {
            list = runner.query(sql,new BeanListHandler<>(Order.class),ordern);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int delOneOrder(int id) {
        String sql ="delete from ljqdb.`order` where id=?";
        int i = 0;
        try {
            i = runner.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int delAllOrder() {
        String sql ="DELETE FROM ljqdb.`order`";
        int i = 0;
        try {
            i = runner.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int addOrder(Order order) {
        int i = 0;
        String sql = "INSERT INTO `ljqdb`.`order` (`person`,`iphone`,`thingname`,`price`) VALUES (?,?,?,?)";
        try {
            i = runner.update(sql,order.getPerson(),order.getIphone(),order.getThingname(),order.getPrice());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public List<Order> findAllOrder() {
        String sql = "select * from ljqdb.order";
        List<Order> list = new ArrayList<>();
        try {
            list=runner.query(sql,new BeanListHandler<>(Order.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

package dao.impl;

import dao.ShopsMapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.Shops;
import utils.C3p0Utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:LeeGaki
 * @date:2021/12/22
 */
public class ShopsMapperImpl implements ShopsMapper {
    QueryRunner runner = new QueryRunner(C3p0Utils.getCon());


    @Override
    public List<Shops> MhFindShop(String name) {
        List<Shops> list = new ArrayList<>();
        String sql="select * from ljqdb.shops where shopname like ?";
        try {
            list = runner.query(sql,new BeanListHandler<>(Shops.class),name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int addShop(Shops shop) {
        int i = 0;
        String sql = "insert into ljqdb.shops(shopname, shopaddr, shopres, shopperson, personiphone) values(?,?,?,?,?)";
        try {
            i = runner.update(sql,shop.getShopname(),shop.getShopaddr(),shop.getShopres(),shop.getShopperson(),shop.getPersoniphone());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int delOneShop(int id) {
        int i = 0;
        String sql = "delete from ljqdb.shops where id=?";
        try {
            i = runner.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int delAllShop() {
        int i = 0;
        String sql = "delete from ljqdb.shops";
        try {
            i = runner.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public List<Shops> findAllShop() {
        List<Shops> list =new ArrayList<>();
        String sql = "select * from ljqdb.shops";
        try {
            list = runner.query(sql,new BeanListHandler<>(Shops.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

package dao.impl;

import dao.ThingsMapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import pojo.Things;
import pojo.User;
import utils.C3p0Utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:LeeGaki
 * @date:2021/12/19
 */
public class ThingsMapperImpl implements ThingsMapper {
    QueryRunner runner = new QueryRunner(C3p0Utils.getCon());
    @Override
    public Things findOneCount(String name) {
        Things thing = new Things();
        String sql = "select * from ljqdb.things where thingname=?";
        try {
            thing = runner.query(sql,new BeanHandler<>(Things.class),name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thing;
    }

    @Override
    public List<Object> findThingname() {
        List<Object> list = new ArrayList<>();
        String sql ="select ljqdb.things.thingname from ljqdb.things";
        try {
            list = runner.query(sql,new ColumnListHandler<>("thingname"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int addThing(Things thing) {
        int i = 0;
        String sql = "insert into ljqdb.things (thingname, thingtype, price, shopping, count) values (?,?,?,?,?)";
        try {
            i = runner.update(sql,thing.getThingname(),thing.getThingtype(),thing.getPrice(),thing.getShopping(),thing.getCount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int upCount(String name,int count) {
        int i = 0;
        String sql = "update ljqdb.things set ljqdb.things.count=? where thingname=?";
        try {
            i = runner.update(sql,count,name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int delOneThing(int id) {
        int i = 0;
        String sql = "DELETE FROM ljqdb.things where id=?";
        try {
            i = runner.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int delAllThing() {
        int i = 0;
        String sql = "DELETE FROM ljqdb.things";
        try {
            i = runner.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public List<Things> seacherThing(String type, String shop) {
        String sql = "select * from ljqdb.things where thingtype=? or shopping=?";
        List<Things> list = new ArrayList<>();
        try {
            list=runner.query(sql,new BeanListHandler<>(Things.class),type,shop);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Things> MhFindThing(String likename) {
        String sql = "select * from ljqdb.things where thingname like ?";
        List<Things> list = new ArrayList<>();
        try {
            list=runner.query(sql,new BeanListHandler<>(Things.class),likename);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Object> SeacherShop() {
        String sql = "select ljqdb.things.shopping from ljqdb.things group by ljqdb.things.shopping";
        List<Object> list = new ArrayList<>();
        try {
            list = runner.query(sql,new ColumnListHandler<>("shopping"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Object> SeacherType() {
        String sql = "select ljqdb.things.thingtype from ljqdb.things group by ljqdb.things.thingtype";
        List<Object> list = new ArrayList<>();
        try {
            list = runner.query(sql,new ColumnListHandler<>("thingtype"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Things> findAllThings() {
        String sql = "select * from ljqdb.things";
        List<Things> list = new ArrayList<>();
        try {
            list=runner.query(sql,new BeanListHandler<>(Things.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Things findOne(int id) {
        Things thing = new Things();
        String sql = "select * from ljqdb.things where id=?";
        try {
            thing = runner.query(sql,new BeanHandler<>(Things.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thing;
    }

}

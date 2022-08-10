package dao.impl;

import dao.UsersMapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import pojo.User;
import utils.C3p0Utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:LeeGaki
 * @date:2021/12/18
 */
public class UserMapperImpl implements UsersMapper {
    QueryRunner runner = new QueryRunner(C3p0Utils.getCon());

    @Override
    public User UsernameFindSupper(String name) {
        User user = new User();
        String sql = "select ljqdb.users.supper from ljqdb.users where username=?";
        try {
            user = runner.query(sql,new BeanHandler<>(User.class),name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<Object> FindAllUsername() {
        List<Object> list = new ArrayList<>();
        String sql = "select ljqdb.users.username from ljqdb.users";
        try {
            list = runner.query(sql,new ColumnListHandler<>("username"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int upUserSupper(Boolean Tf,String name) {
        int i = 0;
        String sql = "update ljqdb.users set supper=? where username=?";
        try {
            i = runner.update(sql,Tf,name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public List<User> MhFind(String name) {
        String sql = "select * from ljqdb.users where username like ?";
        List<User> list = new ArrayList<>();
        try {
            list=runner.query(sql,new BeanListHandler<>(User.class),name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int delOneUser(int id) {
        String sql ="delete from ljqdb.users where id=?";
        int i = 0;
        try {
            i = runner.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int UpPass(int id, String pass) {
        String sql ="update ljqdb.users set password=? where id=?";
        int i = 0;
        try {
            i = runner.update(sql,pass,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int delAllUser() {
        String sql ="DELETE FROM ljqdb.users";
        int i = 0;
        try {
            i = runner.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public int addUser(User user) {
        int i = 0;
        String sql = "insert into ljqdb.users(username,password,sex,iphone,address,email,supper) values(?,?,?,?,?,?,?)";
        try {
            i = runner.update(sql,user.getUsername(),user.getPassword(),user.getSex(),user.getIphone(),user.getAddress(),user.getEmail(),false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    @Override
    public User findId(int id) {
        User user = new User();
        String sql = "select * from ljqdb.users where id=?";
        try {
            user = runner.query(sql,new BeanHandler<>(User.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User login(String name, String pass) {
        String sql = "select * from ljqdb.users where username=? and password=?";
        User user = new User();
        try {
            user = runner.query(sql,new BeanHandler<>(User.class),name,pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        String sql = "select * from ljqdb.users";
        List<User> list = new ArrayList<>();
        try {
            list=runner.query(sql,new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}

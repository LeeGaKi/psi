package dao;

import pojo.User;

import java.util.List;

/**
 * The interface Users mapper.
 *
 * @author:LeeGaki
 * @date:2021/12/18
 */
public interface UsersMapper {


    /**
     * Username find supper user.
     *
     * @param name the name
     * @return the user
     */
    User UsernameFindSupper(String name);

    /**
     * Find all username list.
     *
     * @return the list
     */
    List<Object> FindAllUsername();

    /**
     * Up user supper int.
     *
     * @param Tf   the tf
     * @param name the name
     * @return the int
     */
    int upUserSupper(Boolean Tf, String name);

    /**
     * Mh find list.
     *
     * @param name the name
     * @return the list
     */
    List<User> MhFind(String name);

    /**
     * Del one user int.
     *
     * @param id the id
     * @return the int
     */
    int delOneUser(int id);

    /**
     * Up pass int.
     *
     * @param id   the id
     * @param pass the pass
     * @return the int
     */
    int UpPass(int id, String pass);

    /**
     * Del all user int.
     *
     * @return the int
     */
    int delAllUser();

    /**
     * Add user user.
     *
     * @param user the user
     * @return the user
     */
    int addUser(User user);

    /**
     * Find id user.
     *
     * @param id the id
     * @return the user
     */
    User findId(int id);

    /**
     * Login user.
     *
     * @param name the name
     * @param pass the pass
     * @return the user
     */
    User login(String name, String pass);

    /**
     * Find all list.
     *
     * @return the list
     */
    List<User> findAll();

}

package dao;


import pojo.Order;

import java.util.List;

/**
 * The interface Order mapper.
 *
 * @author:LeeGaki
 * @date:2021/12/19
 */
public interface OrderMapper {

    /**
     * Search order list.
     *
     * @param zhifu   the zhifu
     * @param dingdan the dingdan
     * @return the list
     */
    List<Order> searchOrder(String zhifu,String dingdan);

    /**
     * Search order list.
     *
     * @param ordern the ordern
     * @return the list
     */
    List<Order> searchOrder(String ordern);

    /**
     * Del one order int.
     *
     * @param id the id
     * @return the int
     */
    int delOneOrder(int id);

    /**
     * Del all order int.
     *
     * @return the int
     */
    int delAllOrder();

    /**
     * Add order int.
     *
     * @param order the order
     * @return the int
     */
    int addOrder(Order order);

    /**
     * Find all order list.
     *
     * @return the list
     */
    List<Order> findAllOrder();
}

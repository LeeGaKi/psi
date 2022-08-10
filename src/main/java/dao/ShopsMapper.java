package dao;

import pojo.Shops;

import java.util.List;

/**
 * The interface Shops mapper.
 *
 * @author:LeeGaki
 * @date:2021/12/22
 */
public interface ShopsMapper {

    /**
     * Mh find shop list.
     *
     * @param name the name
     * @return the list
     */
    List<Shops> MhFindShop(String name);

    /**
     * Add shop int.
     *
     * @param shop the shop
     * @return the int
     */
    int addShop(Shops shop);


    /**
     * Del one shop int.
     *
     * @return the int
     */
    int delOneShop(int id);


    /**
     * Del all shop int.
     *
     * @return the int
     */
    int delAllShop();


    /**
     * Find all shop list.
     *
     * @return the list
     */
    List<Shops> findAllShop();


}

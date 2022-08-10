package dao;

import pojo.Things;

import java.util.List;

/**
 * The interface Things mapper.
 *
 * @author:LeeGaki
 * @date:2021/12/18
 */
public interface ThingsMapper {

    /**
     * Find one count things.
     *
     * @param name the name
     * @return the things
     */
    Things findOneCount(String name);
    /**
     * Find thingname list.
     *
     * @return the list
     */
    List<Object> findThingname();

    /**
     * Add thing int.
     *
     * @param thing the thing
     * @return the int
     */
    int addThing(Things thing);

    /**
     * Up count int.
     *
     * @param name  the name
     * @param count the count
     * @return the int
     */
    int upCount(String name,int count);

    /**
     * Del one thing int.
     *
     * @param id the id
     * @return the int
     */
    int delOneThing(int id);


    /**
     * Del all thing int.
     *
     * @return the int
     */
    int delAllThing();

    /**
     * Seacher thing list.
     *
     * @param type the type
     * @param shop the shop
     * @return the list
     */
    List<Things> seacherThing(String type,String shop);

    /**
     * Mh find thing list.
     *
     * @param likename the likename
     * @return the list
     */
    List<Things> MhFindThing(String likename);

    /**
     * Seacher shop list.
     *
     * @return the list
     */
    List<Object> SeacherShop();

    /**
     * Seacher type list.
     *
     * @return the list
     */
    List<Object> SeacherType();

    /**
     * Find all things list.
     *
     * @return the list
     */
    List<Things> findAllThings();

    /**
     * Find one things.
     *
     * @param id the id
     * @return the things
     */
    Things findOne(int id);


}

package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:LeeGaki
 * @date:2021/12/19
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private int id;
    private String person;
    private String iphone;
    private String thingname;
    private int price;
    private String thingtype;
    private String dingdan;
    private String peisong;
    private String zhifu;

}

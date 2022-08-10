package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:LeeGaki
 * @date:2021/12/18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Things {

    private int id;
    private String thingname;
    private String thingtype;
    private int price;
    private String shopping;
    private int count;

}

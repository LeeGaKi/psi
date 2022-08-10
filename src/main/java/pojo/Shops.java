package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:LeeGaki
 * @date:2021/12/22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Shops {
    private int id;
    private String shopname;
    private String shopaddr;
    private String shopres;
    private String shopperson;
    private String personiphone;
}

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
public class User {
    private int id;
    private String username;
    private String password;
    private String sex;
    private String iphone;
    private String address;
    private String email;
    private Boolean supper;

}

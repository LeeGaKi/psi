package utils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;

/**
 * @author:LeeGaki
 * @date:2021/12/18
 */
public class C3p0Utils {

    private static DataSource ds;

    static {
        ds = new ComboPooledDataSource();
    }

    public static DataSource getCon(){
        return ds;
    }
}

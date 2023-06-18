
package Com.Config;

import java.sql.Connection;

public class DatabaseConnect {
    MyConfig Con = new MyConfig();
    Connection MyConfig = Con.getConnect();
}


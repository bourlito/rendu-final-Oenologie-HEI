package datasource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DatasourceProvider {
    private static MysqlDataSource dataSource;

    public static MysqlDataSource getDaraSource(){
        if (dataSource == null){
            dataSource = new MysqlDataSource();
            dataSource.setServerName ("localhost");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("oenologie");
            dataSource.setUser("root");
            dataSource.setPassword("Etl326875");
        }
        return dataSource;
    }
}

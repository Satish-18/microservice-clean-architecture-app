package citytech.global.com.messenging;
import io.micronaut.runtime.Micronaut;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Application {
   public static DataSource dataSource;

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
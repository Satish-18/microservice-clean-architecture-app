package citytech.global.com.messenging;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Singleton
public class DatabaseService {

    @Inject
    private final DataSource dataSource;
    @Inject
    public DatabaseService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void main(){
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT username, password FROM users WHERE userId = 1"; // Modify 'some_condition' as needed
            System.out.println("Statement running ");

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String extractedUsername = resultSet.getString("username");
                    String extractedPassword = resultSet.getString("password");
                    System.out.println("Data Extracted");

                    // Do something with the username and password, e.g., print or store them
                    System.out.println("Username: " + extractedUsername);
                    System.out.println("Password: " + extractedPassword);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

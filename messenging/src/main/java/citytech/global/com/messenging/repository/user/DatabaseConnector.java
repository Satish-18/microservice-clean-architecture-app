package citytech.global.com.messenging.repository.user;

import citytech.global.com.messenging.usecase.sendemail.EmailRequest;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DatabaseConnector {
    private final DataSource dataSource;
    @Inject
    public DatabaseConnector(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void  executePreparedStatement(){
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT email, password FROM users WHERE userId = 1";
            System.out.println("Statement running ");
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String extractedUsername = resultSet.getString("email");
                    String extractedPassword = resultSet.getString("password");
                    System.out.println("Data Extracted");
                    System.out.println("Username: " + extractedUsername);
                    System.out.println("Password: " + extractedPassword);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

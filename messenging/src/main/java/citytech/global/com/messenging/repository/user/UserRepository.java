package citytech.global.com.messenging.repository.user;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@Repository
@JdbcRepository(dialect = Dialect.MYSQL)
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    @Query("SELECT email from emailSender WHERE userId = 1")
    String findEmail();
    @Query("SELECT password from emailSender  WHERE userId =1")
    String findPassword();

}

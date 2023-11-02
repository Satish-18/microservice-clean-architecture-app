package citytech.global.sapatide.usecase.create;

import citytech.global.sapatide.platform.usecase.UseCaseRequest;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
@Introspected
@Serdeable
public record CreateUserRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String userType) implements UseCaseRequest {

}

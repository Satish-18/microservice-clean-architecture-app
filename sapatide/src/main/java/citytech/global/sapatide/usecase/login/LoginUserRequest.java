package citytech.global.sapatide.usecase.login;

import citytech.global.sapatide.platform.usecase.UseCaseRequest;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
@Introspected
@Serdeable
public record LoginUserRequest(
        String email,
        String password
)
        implements UseCaseRequest {

}

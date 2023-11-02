package citytech.global.sapatide.usecase.create;


import citytech.global.sapatide.platform.usecase.UseCaseResponse;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
@Introspected
@Serdeable
public record CreateUserResponse(
        int id,
        String message
        ) implements UseCaseResponse {

}

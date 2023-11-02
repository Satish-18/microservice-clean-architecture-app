package citytech.global.sapatide.usecase.locate;
import citytech.global.sapatide.platform.usecase.UseCaseResponse;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
@Introspected
@Serdeable
public record LocateResponse (
        String country,
        String state,
        String county,
        String category
) implements UseCaseResponse{}


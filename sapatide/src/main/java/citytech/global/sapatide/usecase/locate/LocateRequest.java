package citytech.global.sapatide.usecase.locate;

import citytech.global.sapatide.platform.usecase.UseCaseRequest;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
@Introspected
@Serdeable
public record LocateRequest (
        String longitude,
        String latitude) implements UseCaseRequest{}


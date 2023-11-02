package citytech.global.sapatide.resource.payload;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
@Introspected
@Serdeable
public record LoginUserPayload(
        String email,
        String password
) {
}

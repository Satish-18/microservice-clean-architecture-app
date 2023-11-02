package citytech.global.com.messenging.resource.payload;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
@Serdeable
@Introspected
public record EmailRequestPayload (
        String to,
        String subject,
        String htmlContent){
}

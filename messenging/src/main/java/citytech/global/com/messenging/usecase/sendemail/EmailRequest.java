package citytech.global.com.messenging.usecase.sendemail;
import citytech.global.com.messenging.platform.usecase.UseCaseRequest;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
@Serdeable
@Introspected
public record EmailRequest(
        String from,
        String to,
        String subject,
        String htmlContent
        )  implements UseCaseRequest {}

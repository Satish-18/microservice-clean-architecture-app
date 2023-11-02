package citytech.global.com.messenging.converter;
import citytech.global.com.messenging.resource.payload.EmailRequestPayload;
import citytech.global.com.messenging.usecase.sendemail.EmailRequest;
import citytech.global.com.messenging.usecase.sendemail.EmailRequestBuilder;

public class EmailConverter {
    public static EmailRequest toRequest(EmailRequestPayload payload,String email){
        return EmailRequestBuilder.builder()
                .from(email)
                .to(payload.to())
                .subject(payload.subject())
                .htmlContent(payload.htmlContent())
                .build();
    }
}

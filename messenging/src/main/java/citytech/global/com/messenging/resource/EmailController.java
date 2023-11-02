package citytech.global.com.messenging.resource;

import citytech.global.com.messenging.DatabaseService;
import citytech.global.com.messenging.repository.user.UserRepository;
import citytech.global.com.messenging.resource.payload.EmailRequestPayload;
import citytech.global.com.messenging.usecase.sendemail.EmailUseCase;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import jakarta.inject.Inject;

@Controller("/email")
public class EmailController {

    private final EmailUseCase emailUseCase;
    private final UserRepository userRepository;

    @Inject
    public EmailController(EmailUseCase emailUseCase, UserRepository userRepository) {
        this.emailUseCase = emailUseCase;
        this.userRepository = userRepository;
    }

    @Post("/message")
    public void sendMail(@Body EmailRequestPayload payload) {
        EmailUseCase emailUseCase1 = new EmailUseCase(userRepository);
        emailUseCase1.execute(payload);

    }
}

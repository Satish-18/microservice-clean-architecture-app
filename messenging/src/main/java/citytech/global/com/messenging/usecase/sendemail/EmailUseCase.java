package citytech.global.com.messenging.usecase.sendemail;
import citytech.global.com.messenging.converter.EmailConverter;
import citytech.global.com.messenging.platform.EmailConfig;
import citytech.global.com.messenging.repository.user.DatabaseConnector;
import citytech.global.com.messenging.repository.user.UserRepository;
import citytech.global.com.messenging.resource.payload.EmailRequestPayload;
import jakarta.inject.Inject;

import java.util.Optional;

public class EmailUseCase {
    private  UserRepository userRepository;
    private DatabaseConnector databaseConnector;
    public EmailUseCase() {

    }
    @Inject
    public EmailUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void execute(EmailRequestPayload payload){
        String email = userRepository.findEmail();
        String password = userRepository.findPassword();
        EmailRequest emailRequest =   EmailConverter.toRequest(payload,email);
        EmailConfig.sendMail(emailRequest,password);


    }
}

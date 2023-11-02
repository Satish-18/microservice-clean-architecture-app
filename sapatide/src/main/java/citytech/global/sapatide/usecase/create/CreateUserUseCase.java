package citytech.global.sapatide.usecase.create;
import citytech.global.sapatide.converter.UserConverter;
import citytech.global.sapatide.platform.passwordgenerator.PasswordGenerator;
import citytech.global.sapatide.platform.email.EmailService;
import citytech.global.sapatide.platform.enums.ExceptionType;
import citytech.global.sapatide.platform.exception.SapatideException;
import citytech.global.sapatide.platform.usecase.UseCase;
import citytech.global.sapatide.repository.user.UserEntity;
import citytech.global.sapatide.repository.user.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.inject.Inject;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateUserUseCase implements UseCase<CreateUserRequest,CreateUserResponse> {
    private final UserRepository userRepository;
    @Inject
    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public Optional<CreateUserResponse> execute(CreateUserRequest request) throws IOException,URISyntaxException,InterruptedException,TemplateException{
        validateRequest(request);
        UserEntity entity = UserConverter.toEntity(request);
        entity.setPassword(PasswordGenerator.generate());
        userRepository.save(entity);
        setEmailConfigurationForSignup(entity);
        return Optional.of(new CreateUserResponse(entity.getUserId(), "User is created Successfully"));
    }
    private void  setEmailConfigurationForSignup(UserEntity userEntity) throws IOException, URISyntaxException, InterruptedException, TemplateException {
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
            ClassTemplateLoader templateLoader = new ClassTemplateLoader(EmailService.class, "/templates");
            configuration.setTemplateLoader(templateLoader);
            Template template = configuration.getTemplate("EmailTemplate.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> model = new HashMap<>();
            model.put("username", userEntity.getFirstName());
            model.put("email", userEntity.getEmail());
            System.out.println(userEntity.getPassword());
            model.put("password", userEntity.getPassword());
            model.put("currentYear", "2023");
            template.process(model, writer);
            EmailService emailService = new EmailService(userEntity.getEmail(),writer.toString());
            sendEmailRequest(emailService);
    }
    private void validateRequest(CreateUserRequest request) {
        validateEmail(request);
    }
    private void validateEmail(CreateUserRequest request) {
        Pattern emailPattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9-.]*@gmail[.]com");
        Matcher emailMatcher = emailPattern.matcher(request.email());
        Boolean isValidEmail = emailMatcher.matches();
        Optional<UserEntity> userEntity = this.userRepository.findByEmail(request.email());
        if (isValidEmail.equals(false)) {
            throw new SapatideException(ExceptionType.INVALID_EMAIL);
        }
        if(userEntity.isPresent()){
            throw new SapatideException(ExceptionType.USER_ALREADY_EXIST);
        }
    }
    private void sendEmailRequest(EmailService emailService) throws IOException, InterruptedException, URISyntaxException {
        String json = new ObjectMapper().writeValueAsString(emailService);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8081/email/message"))
                .header("Content-Type", "application/json; charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

    }
}

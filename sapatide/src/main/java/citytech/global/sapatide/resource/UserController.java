package citytech.global.sapatide.resource;
import citytech.global.sapatide.converter.UserConverter;
import citytech.global.sapatide.platform.enums.ExceptionType;
import citytech.global.sapatide.platform.exception.SapatideException;
import citytech.global.sapatide.platform.rest.RestResponse;
import citytech.global.sapatide.resource.payload.CreateUserRequestPayload;
import citytech.global.sapatide.resource.payload.LoginUserPayload;
import citytech.global.sapatide.usecase.create.CreateUserRequest;
import citytech.global.sapatide.usecase.create.CreateUserResponse;
import citytech.global.sapatide.usecase.create.CreateUserUseCase;
import citytech.global.sapatide.usecase.extractusers.ExtractUsersUseCase;
import citytech.global.sapatide.usecase.login.LoginUserRequest;
import citytech.global.sapatide.usecase.login.LoginUserResponse;
import citytech.global.sapatide.usecase.login.LoginUserUseCase;
import freemarker.template.TemplateException;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

@Controller("/user")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final LoginUserUseCase loginUserUseCase;
    @Inject
    private final ExtractUsersUseCase extractUsersUseCase;
    @Inject
    public UserController(CreateUserUseCase createUserUseCase, LoginUserUseCase loginUserUseCase, ExtractUsersUseCase extractUsersUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.loginUserUseCase = loginUserUseCase;
        this.extractUsersUseCase = extractUsersUseCase;
    }

    @Post("/create")
    public HttpResponse<Object> createUser(@Body CreateUserRequestPayload payload) throws TemplateException, IOException, URISyntaxException, InterruptedException {
        CreateUserRequest request = UserConverter.toRequest(payload);

            Optional<CreateUserResponse> createUserResponse = createUserUseCase.execute(request);
            if(createUserResponse.isPresent()){
                return HttpResponse.ok(RestResponse.success(createUserResponse.get().message()));
            }else{
                return HttpResponse.badRequest(RestResponse.error("Create User Response is empty"));
            }
    }

    @Post("/login")
    public HttpResponse<Object> loginUser(@Body LoginUserPayload payLoad) {
            LoginUserRequest loginRequest = UserConverter.toLoginRequest(payLoad);
            Optional<LoginUserResponse> loginResponse = loginUserUseCase.execute(loginRequest);
            if (loginResponse.isPresent())
                return HttpResponse.ok(RestResponse.success(loginResponse.get()));
            throw new SapatideException(ExceptionType.USER_NOT_FOUND);
        }


    @Get("/export")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public HttpResponse<?> exportUsersToExcel() {
        try {
            extractUsersUseCase.generateAndSaveExcel();
            return HttpResponse.ok("Excel file generated and saved.");
        } catch (Exception e) {
            return HttpResponse.badRequest(RestResponse.error(e.getMessage()));
        }

    }

}

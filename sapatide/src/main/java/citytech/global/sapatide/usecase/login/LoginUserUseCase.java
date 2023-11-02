package citytech.global.sapatide.usecase.login;
import citytech.global.sapatide.platform.enums.ExceptionType;
import citytech.global.sapatide.platform.exception.SapatideException;
import citytech.global.sapatide.platform.security.SecurityUtils;
import citytech.global.sapatide.platform.usecase.UseCase;
import citytech.global.sapatide.repository.user.UserEntity;
import citytech.global.sapatide.repository.user.UserRepository;
import jakarta.inject.Inject;
import java.util.Optional;

public class LoginUserUseCase implements UseCase<LoginUserRequest,LoginUserResponse> {
    private final UserRepository userRepository;
    @Inject
    public LoginUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<LoginUserResponse> execute(LoginUserRequest request) {
        Optional<UserEntity> user = userRepository.findByEmail(request.email());
        if(user.isPresent()){
            if(user.get().getPassword().equals(request.password())){
                String token = generateToken(user.get().getEmail(),user.get().getUserType(),user.get().getUserId());
                return Optional.of(new LoginUserResponse("User Login Successful",token));
            }
            throw new SapatideException(ExceptionType.INVALID_CREDENTIAL);
        }
        throw new SapatideException(ExceptionType.INVALID_CREDENTIAL);
    }
    private String generateToken(String email,String userType, int userId){
        SecurityUtils securityUtils = new SecurityUtils();
        return securityUtils.token(email,userType,userId);
    }
}

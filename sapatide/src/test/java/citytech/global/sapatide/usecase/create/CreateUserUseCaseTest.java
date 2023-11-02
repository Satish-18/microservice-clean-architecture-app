package citytech.global.sapatide.usecase.create;
import citytech.global.sapatide.converter.UserConverter;
import citytech.global.sapatide.platform.exception.SapatideException;
import citytech.global.sapatide.repository.user.UserRepository;
import citytech.global.sapatide.resource.payload.CreateUserRequestPayload;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CreateUserUseCaseTest {

    @Inject
    private  CreateUserUseCase createUserUseCase;
    @Inject
    private UserRepository userRepository;


    @BeforeEach
    void setUp(){
        userRepository = Mockito.mock(UserRepository.class);
        createUserUseCase = new CreateUserUseCase(userRepository);
    }

    @Test
    void shouldNotRegisterIfEmailIsIncorrect(){
        CreateUserRequestPayload payload = new CreateUserRequestPayload(
                "satish",
                "subedi",
                "satish11mail@",
                "Borrower"
        );
        CreateUserRequest request = UserConverter.toRequest(payload);
        SapatideException exception = assertThrows(SapatideException.class,() ->{
            createUserUseCase.execute(request);
        });
        assertEquals("Please use valid email",exception.getMessage());
    }

    @Test
    void shouldRegisterIfEmailIsIsCorrect(){
        CreateUserRequestPayload payload = new CreateUserRequestPayload(
                "satish",
                "subedi",
                "satishsubedi45@gmail.com",
                "Borrower"
        );
        CreateUserRequest request = UserConverter.toRequest(payload);
        SapatideException exception = assertThrows(SapatideException.class,() ->{
            createUserUseCase.execute(request);
        });
        assertEquals("User is created Successfully",exception.getMessage());
    }
}
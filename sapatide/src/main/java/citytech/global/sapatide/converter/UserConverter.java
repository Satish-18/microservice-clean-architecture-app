package citytech.global.sapatide.converter;
import citytech.global.sapatide.repository.user.UserEntity;
import citytech.global.sapatide.resource.payload.CreateUserRequestPayload;
import citytech.global.sapatide.resource.payload.LoginUserPayload;
import citytech.global.sapatide.usecase.create.CreateUserRequest;
import citytech.global.sapatide.usecase.create.CreateUserRequestBuilder;
import citytech.global.sapatide.usecase.login.LoginUserRequest;
import citytech.global.sapatide.usecase.login.LoginUserRequestBuilder;

public class UserConverter {
    public static CreateUserRequest toRequest(CreateUserRequestPayload payload){
        return CreateUserRequestBuilder.builder()
                .firstName(payload.firstName())
                .lastName(payload.lastName())
                .email(payload.email())
                .userType(payload.userType())
                .build();
    }

    public static UserEntity toEntity(CreateUserRequest request){
        UserEntity userEntity = new UserEntity("test@example.com", "password");
        userEntity.setFirstName(request.firstName());
        userEntity.setLastName(request.lastName());
        userEntity.setEmail(request.email());
        userEntity.setPassword(request.password());
        userEntity.setUserType(request.userType());
        return userEntity;
    }

    public static LoginUserRequest toLoginRequest(LoginUserPayload payLoad){
        return LoginUserRequestBuilder.builder()
                .email(payLoad.email())
                .password(payLoad.password())
                .build();
    }
}

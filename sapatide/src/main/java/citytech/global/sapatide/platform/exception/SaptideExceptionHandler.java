package citytech.global.sapatide.platform.exception;

import citytech.global.sapatide.platform.rest.RestResponse;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Singleton
@Produces
@Requires(classes = {SapatideException.class, ExceptionHandler.class})
public class SaptideExceptionHandler implements ExceptionHandler<SapatideException, HttpResponse<?>> {
    @Override
    public HttpResponse<?> handle(HttpRequest request, SapatideException exception) {
        String message = exception.getExceptionType().getMessage();
        String code = exception.getExceptionType().getCode();
        return HttpResponse.badRequest().body(RestResponse.error(code,message));

    }
}

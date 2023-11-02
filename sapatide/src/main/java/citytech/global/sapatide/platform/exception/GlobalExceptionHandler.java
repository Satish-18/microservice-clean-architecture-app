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
@Requires(classes = {Exception.class, ExceptionHandler.class})
public class GlobalExceptionHandler implements ExceptionHandler<Exception, HttpResponse<Object>> {
    @Override
    public HttpResponse<Object> handle(HttpRequest request, Exception exception) {
        return HttpResponse.badRequest().body(RestResponse.error(exception.getMessage()));

    }
}

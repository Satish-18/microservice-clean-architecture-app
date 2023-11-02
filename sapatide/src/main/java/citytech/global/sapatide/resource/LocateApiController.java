package citytech.global.sapatide.resource;
import citytech.global.sapatide.platform.enums.ExceptionType;
import citytech.global.sapatide.platform.exception.SapatideException;
import citytech.global.sapatide.platform.rest.RestResponse;
import citytech.global.sapatide.usecase.locate.LocateClient;
import citytech.global.sapatide.usecase.locate.LocateRequest;
import citytech.global.sapatide.usecase.locate.LocateResponse;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

import java.io.IOException;
import java.util.Optional;

@Controller("/api")
public class LocateApiController {

 LocateClient locateClient = new LocateClient();
 @Post("/locate")
public HttpResponse<Object> googleMap(@Body LocateRequest request) throws IOException, InterruptedException {
        String url = "https://api.geoapify.com/v1/geocode/reverse?lon=" +
                request.longitude()
                + "&lat=" + request.latitude() +
                "&apiKey=564884ec8cc1419286c6bd308ea44bf8";
        Optional<LocateResponse> locateResponse = locateClient.post(url);
        if(locateResponse.isPresent())
            return HttpResponse.ok(RestResponse.success(locateResponse));
        else
            throw new SapatideException(ExceptionType.INCORRECT_MAPPED_FIELD);

}
}

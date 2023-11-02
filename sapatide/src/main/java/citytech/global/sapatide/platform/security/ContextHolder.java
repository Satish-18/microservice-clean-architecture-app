package citytech.global.sapatide.platform.security;


import citytech.global.sapatide.platform.enums.ExceptionType;
import citytech.global.sapatide.platform.exception.SapatideException;

public class ContextHolder {
    private static ThreadLocal<RequestContext> context = new ThreadLocal<>();

    public static RequestContext get() {
        if (context == null) {
            throw new SapatideException(ExceptionType.REQUEST_CONTEXT_NOT_SET);
        }
        return context.get();
    }

    public static void set(RequestContext requestContext) {
        if (context == null) {
            context = new ThreadLocal<>();
        }
        context.set(requestContext);
    }

    public static void unset() {
        if (context != null)
            context.remove();
    }
}


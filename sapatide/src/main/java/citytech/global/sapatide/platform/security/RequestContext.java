package citytech.global.sapatide.platform.security;

import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record RequestContext(String subject,
                             String userType,
                             int userID
) {
}

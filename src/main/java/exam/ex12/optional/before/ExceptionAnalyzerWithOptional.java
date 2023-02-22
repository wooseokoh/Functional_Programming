package exam.ex12.optional.before;

import java.util.Optional;

import org.springframework.http.HttpStatus;

public class ExceptionAnalyzerWithOptional {

    public boolean isRetryable(Throwable throwable) {

        final Optional<HttpStatus> httpStatus = getHttpStatus(throwable);
        if (httpStatus.isPresent()) {
            return isRetryable(httpStatus.get());
        }
        return false;
    }

    private static boolean isRetryable(HttpStatus statusCode) {
        return statusCode.is5xxServerError()
                && statusCode == HttpStatus.PROXY_AUTHENTICATION_REQUIRED;
    }

    Optional<HttpStatus> getHttpStatus(Throwable throwable) {
        return Optional.empty();
    }
}

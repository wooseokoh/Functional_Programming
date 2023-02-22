package exam.ex12.optional.functional;

import java.util.Optional;

import org.springframework.http.HttpStatus;

public class ExceptionAnalyzerFilterIsPresent {

    public boolean isRetryable(Throwable throwable) {
        return getHttpStatus(throwable)
                .filter(ExceptionAnalyzerFilterIsPresent::isRetryable)
                .isPresent();
    }

    private static boolean isRetryable(HttpStatus statusCode) {
        return statusCode.is5xxServerError()
                && statusCode == HttpStatus.PROXY_AUTHENTICATION_REQUIRED;
    }

    Optional<HttpStatus> getHttpStatus(Throwable throwable) {
        return Optional.empty();
    }
}
// TODO
// @ControllerAdvice annotation which supports global Exception handler mechanism
// https://www.javadevjournal.com/spring/exception-handling-for-rest-with-spring/

package org.atomiv.template.lite.web.restapi.util;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiErrorResponse {
    //http status code
    private HttpStatus status;

    // in case we want to provide API based custom error code
    private String error_code;

    // customer error message to the client API
    private String message;

    // Any further details which can help client API
    private String detail;

    // Time of the error.make sure to define a standard time zone to avoid any confusion.
    private LocalDateTime timeStamp;

    // getter and setters
    //Builder
    public static final class ApiErrorResponseBuilder {
        private HttpStatus status;
        private String error_code;
        private String message;
        private String detail;
        private LocalDateTime timeStamp;

        public ApiErrorResponseBuilder() {}

        public static ApiErrorResponseBuilder anApiErrorResponse() {

            return new ApiErrorResponseBuilder();
        }

        public ApiErrorResponseBuilder withStatus(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ApiErrorResponseBuilder withError_code(String error_code) {
            this.error_code = error_code;
            return this;
        }

        public ApiErrorResponseBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public ApiErrorResponseBuilder withDetail(String detail) {
            this.detail = detail;
            return this;
        }

        public ApiErrorResponseBuilder atTime(LocalDateTime timeStamp) {
            this.timeStamp = timeStamp;
            return this;
        }
        public ApiErrorResponse build() {
            ApiErrorResponse apiErrorResponse = new ApiErrorResponse();
            apiErrorResponse.status = this.status;
            apiErrorResponse.error_code = this.error_code;
            apiErrorResponse.detail = this.detail;
            apiErrorResponse.message = this.message;
            apiErrorResponse.timeStamp = this.timeStamp;
            return apiErrorResponse;
        }
    }
}

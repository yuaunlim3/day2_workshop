package PAF.day2_workshop.Exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import PAF.day2_workshop.Models.exception.ApiError;
import PAF.day2_workshop.Models.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleException(ResourceNotFoundException ex, HttpServletRequest request,
            HttpServletResponse response) {

        ApiError apiError = new ApiError(404, ex.getMessage(), new Date());

        return new ResponseEntity<ApiError>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

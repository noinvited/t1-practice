package ru.t1.practice.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import ru.t1.practice.dto.*;

@ControllerAdvice(annotations = RestController.class)
public class CommonControllerAdvice {
    @ExceptionHandler(InvalidRequestCategoryException.class)
    public ResponseEntity<BadRequestCategoryResponse> handleInvalidRequestCategoryException(InvalidRequestCategoryException e) {
        return ResponseEntity.status(e.getStatus()).body(new BadRequestCategoryResponse(e.getMessage(), new BadRequestCategoryDetails(e.getCategory())));
    }

    @ExceptionHandler(InvalidRequestSectionException.class)
    public ResponseEntity<BadRequestSectionResponse> handleInvalidRequestSectionException(InvalidRequestSectionException e) {
        return ResponseEntity.status(e.getStatus()).body(new BadRequestSectionResponse(e.getMessage(), new BadRequestSectionDetails(e.getSection())));
    }

    @ExceptionHandler(InvalidRequestCategoryAndSectionException.class)
    public ResponseEntity<BadRequestCategoryAndSectionResponse> handleInvalidRequestCategoryAndSectionException(InvalidRequestCategoryAndSectionException e) {
        return ResponseEntity.status(e.getStatus()).body(new BadRequestCategoryAndSectionResponse(e.getMessage(), new BadRequestCategoryAndSectionDetails(e.getCategory(), e.getSection())));
    }

    @ExceptionHandler(ServerException.class)
    public ResponseEntity<ServerErrorResponse> handleServerException(ServerException e) {
        return ResponseEntity.status(e.getStatus()).body(new ServerErrorResponse(e.getError(), e.getMessage()));
    }
}

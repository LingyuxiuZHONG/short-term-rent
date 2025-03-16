package com.example.common.exception;

import com.example.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<String>> handleValidationException(MethodArgumentNotValidException ex) {
        // 获取验证失败的第一个错误信息
        String errorMessage = ex.getBindingResult().getFieldError().getDefaultMessage();

        // 抛出业务异常
       return handleBusinessException(new BusinessException(errorMessage));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<String>> handleBusinessException(BusinessException ex) {
        // 返回定制化的错误信息给前端
        ApiResponse<String> response = ApiResponse.error(400, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ApiResponse<String>> handleGenericException(Exception ex) {
//        // 捕获其他所有未处理的异常
//        ApiResponse<String> response = ApiResponse.error(500, "系统内部错误，请稍后重试");
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
//    }


}

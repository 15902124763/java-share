package com.niki.account.handler;

import com.niki.account.constants.BizException;
import com.niki.account.constants.ErrorCode;
import com.niki.account.vo.Result;
import com.niki.account.vo.ResultState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.xml.bind.ValidationException;


/**
 * @author baicheng
 * @description
 * @create 2019-09-04 10:11
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result<Void> handleError(MissingServletRequestParameterException e) {
        log.warn("Missing Request Parameter", e);
        String message = String.format("Missing Request Parameter: %s", e.getParameterName());
        return Result.customFaillbackResult(String.valueOf(ResultState.PARAM_ERROR.getCode()), message);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Result<Void> handleError(MethodArgumentTypeMismatchException e) {
        log.warn("Method Argument Type Mismatch", e);
        String message = String.format("Method Argument Type Mismatch: %s", e.getName());
        return Result.customFaillbackResult(String.valueOf(ResultState.PARAM_ERROR.getCode()), message);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public Result<Void> handleError(MethodArgumentNotValidException e) {
        log.warn("Method Argument Not Valid", e);
        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();
        String message = String.format("%s:%s", error.getField(), error.getDefaultMessage());
        return Result.customFaillbackResult(String.valueOf(ResultState.PARAM_ERROR.getCode()), message);
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    public Result<Void> handleError(NoHandlerFoundException e) {
        log.error("404 Not Found", e);
        return Result.customFaillbackResult(String.valueOf(ResultState.FAILED.getCode()), e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result<Void> handleError(HttpMessageNotReadableException e) {
        log.error("Message Not Readable", e);
        return Result.customFaillbackResult(String.valueOf(ResultState.FAILED.getCode()), e.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result<Void> handleError(HttpRequestMethodNotSupportedException e) {
        log.error("Request Method Not Supported", e);
        return Result.customFaillbackResult(String.valueOf(ResultState.FAILED.getCode()), e.getMessage());
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Result<Void> handleError(HttpMediaTypeNotSupportedException e) {
        log.error("Media Type Not Supported", e);
        return Result.customFaillbackResult(String.valueOf(ResultState.PARAM_ERROR.getCode()), e.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Void> validationExceptionHandler(ValidationException e){
        log.error("Invalid param error", e);
        return Result.customFaillbackResult(String.valueOf(ResultState.PARAM_ERROR.getCode()), e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    public Result<Void> handleError(Throwable e) {
        log.error("Internal Server Error", e);
        return handleThrowable(e);
    }
    @ExceptionHandler(BizException.class)
    public Result<Void> handleError(BizException e) {
        log.error("Server BizException Error", e.getMessage());
        Result result = new Result();
        try {
            result.setCode(Integer.parseInt(e.getErrorCode()));
        }catch (Exception e1){
            result.setCode(-1);
        }
        result.setMessage(e.getErrorMsg());
        return result;
    }

    public static Result<Void> handleThrowable(Throwable throwable) {
        Result<Void> throwableRe = new Result<>();
        // 业务异常
        if(throwable instanceof BizException){
            try {
                throwableRe.setCode(Integer.parseInt( ((BizException) throwable).getErrorCode()));
            }catch (Exception e1){
                throwableRe.setCode(-2);
            }
            throwableRe.setMessage(throwable.getMessage());
            return throwableRe;
        }
        // 未知异常
        throwableRe.setCode(ErrorCode.UNKNOWN_ERROR.getCode());
        throwableRe.setMessage(ErrorCode.UNKNOWN_ERROR.getMsg());
        return throwableRe;
    }

    /**
     * @Description :异常统一处理
     * @Author : yarm.yang
     * @Date : 2020/3/27 16:48
     */
    public static Result<Void> handleExeption(Exception e) {
        Result<Void> result = new Result<>();
        // 业务异常
        if(e instanceof BizException){
            try {
                result.setCode(Integer.parseInt( ((BizException) e).getErrorCode()));
            }catch (Exception e1){
                result.setCode(-2);
            }
            result.setMessage(e.getMessage());
            return result;
        }
        // 未知异常
        result.setCode(ErrorCode.UNKNOWN_ERROR.getCode());
        result.setMessage(ErrorCode.UNKNOWN_ERROR.getMsg());
        return result;
    }
}

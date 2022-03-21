package com.kunmall.product.config;

import com.kunmall.common.exception.BizCodeEnume;
import com.kunmall.common.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(basePackages = "com.kunmall.product.controller")
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public CommonResult handleValidException(MethodArgumentNotValidException e){
      log.error("参数校验失败{}", e.getMessage());
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> map = new HashMap<>();
        bindingResult.getFieldErrors().forEach(
                item -> map.put(item.getField(), item.getDefaultMessage())
        );
        return CommonResult.error(BizCodeEnume.VAILD_EXCEPTION.getCode(), BizCodeEnume.VAILD_EXCEPTION.getMsg()).put("data", map);
    }
}

package com.codegym.hotelmanagement.myException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView handleResourceNotFound(ResourceNotFoundException ex) {
        ModelAndView mav = new ModelAndView("error/404-page");
        mav.addObject("message", ex.getMessage());
        return mav;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleNoHandlerFound(NoHandlerFoundException ex) {
        ModelAndView mav = new ModelAndView("error/404-page");
        mav.addObject("message", "Trang bạn truy cập không tồn tại.");
        return mav;
    }

    // (Tùy chọn) Xử lý các lỗi khác nếu cần
    @ExceptionHandler(Exception.class)
    public ModelAndView handleGeneralException(Exception ex) {
        ModelAndView mav = new ModelAndView("error/500");
        mav.addObject("message", "Đã xảy ra lỗi nội bộ.");
        return mav;
    }
}

package Franciscobusleiman.recipes.recipes.exceptions;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ModelAndView notFoundException(Exception exception){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("exceptions/NotFoundException");
        modelAndView.addObject("exception" , exception);

        return modelAndView;

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({NumberFormatsException.class})
    public ModelAndView numberFormatsException(Exception exception){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("exceptions/NumberFormatException");
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }


}

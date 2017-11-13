package exceptions;

import com.springrest.model.nyt.CustomResponseObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ResponseBody
    @ExceptionHandler(SectionNotFoundException.class)
    public CustomResponseObject APINotFoundExceptionHandler (SectionNotFoundException ae){
        CustomResponseObject responce = new CustomResponseObject();

        responce.setError(ae.getMessage());
        responce.setStatus_code(ae.getStatus_code());
        responce.setMessage(ae.getMessage());

        return responce;
    }

}

package school.sptech.exemplo_strategy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class FreteInvalidoException extends RuntimeException {
    public FreteInvalidoException(String message) {
        super(message);
    }

}

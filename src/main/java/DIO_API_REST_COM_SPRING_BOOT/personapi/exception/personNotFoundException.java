package DIO_API_REST_COM_SPRING_BOOT.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class personNotFoundException extends Exception {

    public personNotFoundException(long id) {
        super("Person not found with ID " + id);
    }
}

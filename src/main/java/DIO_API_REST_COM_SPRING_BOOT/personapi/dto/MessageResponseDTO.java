package DIO_API_REST_COM_SPRING_BOOT.personapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDTO {
    private String message;
}

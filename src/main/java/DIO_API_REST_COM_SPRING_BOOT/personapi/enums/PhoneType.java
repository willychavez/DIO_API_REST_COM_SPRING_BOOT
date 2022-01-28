package DIO_API_REST_COM_SPRING_BOOT.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum PhoneType {

    HOME("home"),
    MOBILE("Mobile"),
    COMMERCIAL("Commercial");

    private final String description;
}

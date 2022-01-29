package DIO_API_REST_COM_SPRING_BOOT.personapi.utils;

import DIO_API_REST_COM_SPRING_BOOT.personapi.dto.request.PhoneDTO;
import DIO_API_REST_COM_SPRING_BOOT.personapi.entity.Phone;
import DIO_API_REST_COM_SPRING_BOOT.personapi.enums.PhoneType;

public class PhoneUtils {
    private static final String PHONE_NUMBER = "1699999-9999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}

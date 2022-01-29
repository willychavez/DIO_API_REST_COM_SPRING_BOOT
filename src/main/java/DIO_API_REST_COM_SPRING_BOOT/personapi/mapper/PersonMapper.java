package DIO_API_REST_COM_SPRING_BOOT.personapi.mapper;

import DIO_API_REST_COM_SPRING_BOOT.personapi.dto.request.PersonDTO;
import DIO_API_REST_COM_SPRING_BOOT.personapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}

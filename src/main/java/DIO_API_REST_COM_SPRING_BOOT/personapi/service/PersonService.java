package DIO_API_REST_COM_SPRING_BOOT.personapi.service;

import DIO_API_REST_COM_SPRING_BOOT.personapi.dto.MessageResponseDTO;
import DIO_API_REST_COM_SPRING_BOOT.personapi.entity.Person;
import DIO_API_REST_COM_SPRING_BOOT.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person whit ID " + savedPerson.getId())
                .build();
    }
}

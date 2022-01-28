package DIO_API_REST_COM_SPRING_BOOT.personapi.controller;

import DIO_API_REST_COM_SPRING_BOOT.personapi.dto.MessageResponseDTO;
import DIO_API_REST_COM_SPRING_BOOT.personapi.entity.Person;
import DIO_API_REST_COM_SPRING_BOOT.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person whit ID " + savedPerson.getId())
                .build();
    }
}

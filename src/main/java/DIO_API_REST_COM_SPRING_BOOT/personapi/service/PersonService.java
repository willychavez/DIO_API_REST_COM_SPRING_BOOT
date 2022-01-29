package DIO_API_REST_COM_SPRING_BOOT.personapi.service;

import DIO_API_REST_COM_SPRING_BOOT.personapi.dto.request.PersonDTO;
import DIO_API_REST_COM_SPRING_BOOT.personapi.dto.response.MessageResponseDTO;
import DIO_API_REST_COM_SPRING_BOOT.personapi.entity.Person;
import DIO_API_REST_COM_SPRING_BOOT.personapi.exception.personNotFoundException;
import DIO_API_REST_COM_SPRING_BOOT.personapi.mapper.PersonMapper;
import DIO_API_REST_COM_SPRING_BOOT.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person whit ID " + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(long id) throws personNotFoundException {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isEmpty()) {
            throw new personNotFoundException(id);
        }
        return personMapper.toDTO(optionalPerson.get());
    }
}

package DIO_API_REST_COM_SPRING_BOOT.personapi.service;

import DIO_API_REST_COM_SPRING_BOOT.personapi.dto.request.PersonDTO;
import DIO_API_REST_COM_SPRING_BOOT.personapi.dto.response.MessageResponseDTO;
import DIO_API_REST_COM_SPRING_BOOT.personapi.entity.Person;
import DIO_API_REST_COM_SPRING_BOOT.personapi.exception.PersonNotFoundException;
import DIO_API_REST_COM_SPRING_BOOT.personapi.mapper.PersonMapper;
import DIO_API_REST_COM_SPRING_BOOT.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return createMessageResponse("Created person whit ID ", savedPerson.getId());
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(long id) throws DIO_API_REST_COM_SPRING_BOOT.personapi.exception.PersonNotFoundException {
        Person person = verifyIfExist(id);
        return personMapper.toDTO(person);
    }


    public void delete(long id) throws PersonNotFoundException {
        verifyIfExist(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExist(id);
        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatedPerson = personRepository.save(personToUpdate);
        return createMessageResponse("Updated person whit ID ", updatedPerson.getId());
    }

    private Person verifyIfExist(long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(String message, long id) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}

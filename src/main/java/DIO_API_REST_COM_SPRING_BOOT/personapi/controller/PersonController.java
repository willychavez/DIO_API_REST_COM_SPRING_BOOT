package DIO_API_REST_COM_SPRING_BOOT.personapi.controller;

import DIO_API_REST_COM_SPRING_BOOT.personapi.dto.request.PersonDTO;
import DIO_API_REST_COM_SPRING_BOOT.personapi.dto.response.MessageResponseDTO;
import DIO_API_REST_COM_SPRING_BOOT.personapi.exception.personNotFoundException;
import DIO_API_REST_COM_SPRING_BOOT.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable long id) throws personNotFoundException {
        return personService.findById(id);
    }
}

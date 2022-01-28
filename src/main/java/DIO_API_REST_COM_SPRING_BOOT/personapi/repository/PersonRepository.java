package DIO_API_REST_COM_SPRING_BOOT.personapi.repository;

import DIO_API_REST_COM_SPRING_BOOT.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

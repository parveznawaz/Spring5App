package guru.springframework.spring5webApp.repositories;

import guru.springframework.spring5webApp.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author,Long> {

}

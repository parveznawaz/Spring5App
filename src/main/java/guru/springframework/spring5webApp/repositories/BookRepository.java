package guru.springframework.spring5webApp.repositories;

import guru.springframework.spring5webApp.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book,Long> {

}

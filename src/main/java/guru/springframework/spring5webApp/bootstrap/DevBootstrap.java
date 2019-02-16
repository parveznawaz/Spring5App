package guru.springframework.spring5webApp.bootstrap;

import guru.springframework.spring5webApp.model.Author;
import guru.springframework.spring5webApp.model.Book;
import guru.springframework.spring5webApp.repositories.AuthorRepository;
import guru.springframework.spring5webApp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private void initData() {
        Author eric=new Author("Eric","Evants");
        Book ddd=new Book("Domain design","1234","Harpar");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod=new Author("Johnson","Rod");
        Book noEjb=new Book("J2EE no Ejb","3834","Wrox");
        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEjb);
    }
}

package guru.springframework.spring5webApp.bootstrap;

import guru.springframework.spring5webApp.model.Author;
import guru.springframework.spring5webApp.model.Book;
import guru.springframework.spring5webApp.model.Publisher;
import guru.springframework.spring5webApp.repositories.AuthorRepository;
import guru.springframework.spring5webApp.repositories.BookRepository;
import guru.springframework.spring5webApp.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    private void initData() {
        Publisher publisher1=new Publisher("Harpar","Toronto");
        Publisher publisher2=new Publisher("Wrox","Newyork");
        publisherRepository.save(publisher1);
        publisherRepository.save(publisher2);

        Author eric=new Author("Eric","Evants");
        Book ddd=new Book("Domain design","1234",publisher1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod=new Author("Johnson","Rod");
        Book noEjb=new Book("J2EE no Ejb","3834",publisher2);
        rod.getBooks().add(noEjb);
        noEjb.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEjb);
    }
}

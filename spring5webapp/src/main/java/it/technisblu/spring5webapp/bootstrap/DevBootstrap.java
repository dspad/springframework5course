package it.technisblu.spring5webapp.bootstrap;

import it.technisblu.spring5webapp.model.Author;
import it.technisblu.spring5webapp.model.Book;

import it.technisblu.spring5webapp.model.Publisher;
import it.technisblu.spring5webapp.repositories.AuthorRepository;
import it.technisblu.spring5webapp.repositories.BookRepository;
import it.technisblu.spring5webapp.repositories.PublisherRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 5/16/17.
 */
@Component
public class DevBootstrap implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String...  args) throws Exception{

        Author spadoni = new Author("Daniele", "Spadoni");
        Publisher publisherTech = new Publisher("Technis Blu","Viale Luigi Schiavonetti 290","Roma","Italy","00128");
        Book  simog = new Book("Simog per negati", "1234", publisherTech);
        spadoni.getBooks().add(simog);
        simog.getAuthors().add(spadoni);

        Author andreini = new Author("Daniele", "Andreini");
        Book supporto = new Book("Come gestire un ticket", "23444", publisherTech );
        andreini.getBooks().add(supporto);
        supporto.getAuthors().add(andreini);
        
        publisherRepository.save(publisherTech);
        saveBook(spadoni,simog);
        saveBook(andreini,supporto);
        
        publisherTech.getBooks().add(simog);
        publisherTech.getBooks().add(supporto);
        
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books "+bookRepository.count());
        System.out.println("Publisher Number of Books " + publisherTech.getBooks().size());
       
    }
    
    private void saveBook(Author author, Book book) {
        authorRepository.save(author);
        bookRepository.save(book);
    }
}

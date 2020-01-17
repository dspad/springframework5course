package it.technisblu.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import it.technisblu.spring5webapp.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}

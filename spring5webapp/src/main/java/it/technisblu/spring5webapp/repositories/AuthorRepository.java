package it.technisblu.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import it.technisblu.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}

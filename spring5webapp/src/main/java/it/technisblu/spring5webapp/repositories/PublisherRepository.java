package it.technisblu.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;

import it.technisblu.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}

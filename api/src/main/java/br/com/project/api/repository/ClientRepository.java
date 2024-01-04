package br.com.project.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.project.api.model.ClientModel;


@Repository
public interface ClientRepository extends CrudRepository<ClientModel, Long> {

}

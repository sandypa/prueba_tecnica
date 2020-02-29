package com.prueba.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prueba.core.entity.Registro;

@Repository
public interface RegistroRepository extends CrudRepository<Registro, Long>{

}

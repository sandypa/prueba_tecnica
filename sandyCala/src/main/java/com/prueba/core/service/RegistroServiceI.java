package com.prueba.core.service;

import java.util.List;

import com.prueba.core.entity.Registro;

public interface RegistroServiceI {

	List<Registro> findAll();
	Registro findId(Long id);
	List<Registro> save(Registro registro);
}

package com.prueba.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.core.entity.Registro;
import com.prueba.core.repository.RegistroRepository;

@Service
public class RegistroService implements RegistroServiceI {

	@Autowired
    private RegistroRepository repository;

    @Override
    public List<Registro> findAll() {

        return (List<Registro>) repository.findAll();
    }
    
    public Registro findId(Long id)
    {
    	return repository.findById(id).get();
    }
    
    public List<Registro> save(Registro registro) {
    	
    	try {
    		repository.save(registro);
            return (List<Registro>) repository.findAll();
		} catch (Exception e) {
			return null;
		}    	    	
    }
}

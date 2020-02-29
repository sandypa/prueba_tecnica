package com.prueba.core.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Soundbank;
import javax.validation.Valid;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.prueba.core.entity.Registro;
import com.prueba.core.service.RegistroServiceI;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class RegistroController {

	@Autowired
	private RegistroServiceI registroService;
	
	@RequestMapping(value="/registros", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Registro> findAll(Model model) {

    	return registroService.findAll();
    }      
    
    @RequestMapping(value="/registro/{id}", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public Registro findRegistro(Model model, @PathVariable Long id) {

    	return registroService.findId(id);
    }
    
    @RequestMapping(value="/registro", method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Registro> crear(@RequestBody @Valid Registro registro) {

    	return registroService.save(registro);
    }
    
    @RequestMapping(value="/leer", method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Registro> crearArchivo() {
    	
        try {
            
        	String cadena;
        	int diasTrabajados=0;
        	int articulos = 0;
        	int cntArticulos = 0;
        	int ctnViajes = 0;
        	List<Integer> lista = new ArrayList<Integer>();
        	List<Integer> pesos = new ArrayList<Integer>();
        	
            FileReader fr = new FileReader("src/main/resources/lazy_loading_example_input.txt");
            BufferedReader bf = new BufferedReader(fr);
            
            while ((cadena = bf.readLine())!=null) {
        	   System.out.println(cadena);
        	   lista.add(Integer.parseInt(cadena));            	   
        	}
            
            for (int i = 0; i < lista.size(); i++) {
				if(diasTrabajados == 0) {
					diasTrabajados = lista.get(i);
				}else {
					for (int j = 0; j < diasTrabajados; j++) {
						if(articulos == 0) {
							articulos = lista.get(i);
							break;
						}else {
							if(cntArticulos < articulos) {
								System.out.println("solo pesos "+lista.get(i));
								pesos.add(lista.get(i));   
								cntArticulos++;
								break;
							}
							for (int k = 0; k < pesos.size(); k++) {
								
								if(pesos.get(k) > 50) {
									ctnViajes ++;
								}
								
							}
							System.out.println("viajes "+ctnViajes);
							cntArticulos=0;
							articulos=0;
							ctnViajes=0;
						}
					}
				}
			}
            System.out.println("dias "+diasTrabajados);
            bf.close();
        }catch (Exception e) {
			// TODO: handle exception
		}

    	return registroService.findAll();
    }
}

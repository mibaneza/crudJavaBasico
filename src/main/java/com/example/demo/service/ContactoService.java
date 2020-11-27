package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Contacto;
import com.example.demo.repository.ContactoRepository;

@Service
public class ContactoService {
	private ContactoRepository conR;
	
	public List<Contacto> findAll(){
		return (List<Contacto>)conR.findAll();
	}
	public Contacto findContacto(Long id){
		 return conR.findById(id).orElse(null);
	}
	public void deleteContacto(Long id) {
		conR.deleteById(id);
	}
	
	public Contacto updateContacto(Contacto contacto){
		return (Contacto)conR.save(contacto);		
	}
	public Contacto saveContacto(Contacto contacto){
		return (Contacto)conR.save(contacto);		
	}
}

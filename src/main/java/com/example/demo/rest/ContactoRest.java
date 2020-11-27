package com.example.demo.rest;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Contacto;
import com.example.demo.service.ContactoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ContactoRest {
	private ContactoService conS;
	
	@GetMapping("/contactos")
	@ResponseStatus(HttpStatus.OK)
	public List<Contacto> getContactos(){
		return conS.findAll();
	}
	
	@PostMapping("/contacto")
	public ResponseEntity<Void> addContacto (@RequestBody Contacto contacto){
	    conS.saveContacto(contacto);
	    return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping("/contacto")
	public ResponseEntity<?> updateContacto (@RequestBody Contacto contacto) throws Exception{
		Contacto contactoDb = null;
		contactoDb = conS.findContacto(contacto.getId());
		if(contactoDb != null) {
			contactoDb.setId(contacto.getId());
			contactoDb.setNombre(contacto.getNombre());
			contactoDb.setMail(contacto.getMail());
			contactoDb.setComentario(contacto.getComentario());
			return new ResponseEntity<>(contactoDb, HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			
		}
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Void> deleteProfesor(@PathVariable(value = "id")Long id){
		conS.deleteContacto(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	

}

package com.stefanini.treinamento.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.stefanini.treinamento.exceptions.MotoException;
import com.stefanini.treinamento.model.Moto;
import com.stefanini.treinamento.service.MotoService;

@CrossOrigin
@RestController
@RequestMapping(value="/moto")
public class MotoController {
	
	@Autowired
	private MotoService motoService;
	
	@GetMapping
	public List<Moto> findAll(){
		return motoService.findAll();
	}
	
	@GetMapping("/{nome}")
	public ResponseEntity<List<Moto>> searchByName(@PathVariable String nome){
		List<Moto> motosEncontradas = motoService.searchByName(nome);
		if(motosEncontradas == null) {
			return ResponseEntity.ok(null);
			}
		return ResponseEntity.ok(motosEncontradas);
	}
	
	@PostMapping
	public ResponseEntity<Object> create(@RequestBody Moto moto){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(motoService.create(moto));
		} catch (MotoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{id_moto}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id_moto) {
		motoService.delete(id_moto);
	}
	
	@PutMapping
	public ResponseEntity<Moto> update(@RequestBody Moto moto){
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(motoService.update(moto));
	}

}

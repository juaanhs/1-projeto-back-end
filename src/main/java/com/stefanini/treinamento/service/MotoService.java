package com.stefanini.treinamento.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stefanini.treinamento.exceptions.MotoException;
import com.stefanini.treinamento.model.Moto;
import com.stefanini.treinamento.model.Capacete;
import com.stefanini.treinamento.repository.MotoRepository;

@Service
public class MotoService {

	@Autowired
	private MotoRepository motoRepository;
	public List<Moto> findAll(){
		return motoRepository.findAll();
	}
	
	public List<Moto> searchByName(String nome){
		return motoRepository.searchByName(nome);
	}
	
	public Moto create(Moto moto) throws MotoException {
		Moto motoEncontrada = motoRepository.buscarPorNomeUnico(moto.getNome());
		
		if(motoEncontrada != null) {
			throw new MotoException("MOTO DUPLICADA!!!");
		}
		
		Moto motoSalva = motoRepository.save(moto);
		if(moto.getCapacetes() != null) {
			moto.getCapacetes().forEach(capacete->{
				capacete.setId_moto(motoSalva.getId_moto());
			});
		}
		
		 motoRepository.save(moto);
		 return motoSalva;
	}
	
	public Moto update(Moto moto) {
		for(Capacete p: moto.getCapacetes()) {
			if(p.getId_capacete() == null) {
				p.setId_moto(moto.getId_moto());
			}
		}
		return motoRepository.save(moto);
	}
	
	
	public void delete(Long id_moto) {
		motoRepository.deleteById(id_moto);
	}
}

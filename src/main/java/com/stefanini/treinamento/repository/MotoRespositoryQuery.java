package com.stefanini.treinamento.repository;

import java.util.List;
import com.stefanini.treinamento.model.Moto;

public interface MotoRespositoryQuery {

	public List<Moto> searchByName(String nome);
	public Moto buscarPorNomeUnico(String nome);
	
}

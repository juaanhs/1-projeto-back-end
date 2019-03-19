package com.stefanini.treinamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stefanini.treinamento.model.Moto;

public interface MotoRepository extends JpaRepository<Moto, Long>, MotoRespositoryQuery{

}

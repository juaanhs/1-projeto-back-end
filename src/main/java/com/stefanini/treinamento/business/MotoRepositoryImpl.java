package com.stefanini.treinamento.business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.stefanini.treinamento.model.Moto;
import com.stefanini.treinamento.repository.MotoRespositoryQuery;

@Repository
public class MotoRepositoryImpl implements MotoRespositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	@Override
	public List<Moto> searchByName(String nome) {
		List<Moto> motoEncontradas = null;
		try {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<Moto> criteriaQuery = builder.createQuery(Moto.class);
			Root<Moto>root =criteriaQuery.from(Moto.class);
//			Join<Moto, Capacete>capacetes = root.join("capacetes",JoinType.INNER);
			Predicate[] predicates =restricao1(nome,builder,root);
			criteriaQuery.where(predicates);
			
			TypedQuery<Moto>typedQuery = manager.createQuery(criteriaQuery);
			motoEncontradas = typedQuery.getResultList();
			
			return motoEncontradas;
		} catch (Exception e) {
			return motoEncontradas;
		}
	}

	private Predicate[] restricao1(String nome, CriteriaBuilder builder, Root<Moto> root) {
		List<Predicate> predicates  = new ArrayList<>();
		if(!StringUtils.isEmpty(nome)) {
			predicates.add(builder.like(builder.lower(root.get("nome")), "%"+(nome.toLowerCase())+"%"));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	@Override
	public Moto buscarPorNomeUnico(String nome) {
		Moto motoEncontradas = null;
		try {
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<Moto> criteriaQuery = builder.createQuery(Moto.class);
			Root<Moto>root =criteriaQuery.from(Moto.class);
			Predicate[] predicates =restricao2(nome,builder,root);
			criteriaQuery.where(predicates);
			
			TypedQuery<Moto>typedQuery = manager.createQuery(criteriaQuery);
			motoEncontradas = typedQuery.getSingleResult();
			
			return motoEncontradas;
		} catch (Exception e) {
			return motoEncontradas;
		}
		
	}

	private Predicate[] restricao2(String nome, CriteriaBuilder builder, Root<Moto> root) {
		List<Predicate> predicates  = new ArrayList<>();
		if(!StringUtils.isEmpty(nome)) {
			predicates.add(builder.like(builder.lower(root.get("nome")), "%"+(nome.toLowerCase())+"%"));
		}
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	

}

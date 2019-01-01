package com.devwebpb.domgilittus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devwebpb.domgilittus.model.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Long>{
	
	Tipo findById(Long Id);

}

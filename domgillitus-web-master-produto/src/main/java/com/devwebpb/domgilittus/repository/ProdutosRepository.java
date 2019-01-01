package com.devwebpb.domgilittus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devwebpb.domgilittus.model.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long>{

	Produtos findById(Long Id);
	
}

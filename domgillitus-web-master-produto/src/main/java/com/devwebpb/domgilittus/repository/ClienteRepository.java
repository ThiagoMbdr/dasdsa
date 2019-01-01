package com.devwebpb.domgilittus.repository;

import com.devwebpb.domgilittus.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findById(Long id);

}

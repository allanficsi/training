package com.training.dao;

import com.training.model.topico.entity.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico,Long> {

    Page<Topico> findByCursoNome(String filtro, Pageable pageable);
}

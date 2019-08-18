package com.training.model.usuario.service;

import com.training.model.usuario.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>
{
    Optional<Usuario> findByEmail(String email);
}

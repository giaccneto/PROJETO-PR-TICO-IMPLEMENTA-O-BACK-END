package com.giaccneto.Seletivo_SEPLAG.infraestructure.repository;

import com.giaccneto.Seletivo_SEPLAG.infraestructure.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    boolean existsByEmail(String email);
    Optional<Usuario> findByEmail(String email);
}

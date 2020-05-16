package me.alecio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.alecio.backend.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}
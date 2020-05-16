package me.alecio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.alecio.backend.models.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long>{}

package me.alecio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.alecio.backend.models.Aviso;

@Repository
public interface AvisoRepository extends JpaRepository<Aviso, Long> {}
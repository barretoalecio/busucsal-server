package me.alecio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.alecio.backend.models.Sugestoes;

@Repository
public interface SugestoesRepository extends JpaRepository<Sugestoes, Long>{}
package me.alecio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.alecio.backend.models.Roteiro;

@Repository
public interface RoteiroRepository extends JpaRepository<Roteiro, Long>{}
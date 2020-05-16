package me.alecio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.alecio.backend.models.StatusBusucsal;

@Repository
public interface StatusBusucsalRepository extends JpaRepository<StatusBusucsal, Long> {}

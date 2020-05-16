package me.alecio.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.alecio.backend.models.Aviso;
import me.alecio.backend.repository.AvisoRepository;

@Service
public class AvisoService {
	@Autowired
	private AvisoRepository repository;

	public Aviso create(Aviso aviso) {
		return this.repository.save(aviso);
	}

	public List<Aviso> research() {
		return this.repository.findAll();
	}

	public Optional<Aviso> research(Long id) {
		return this.repository.findById(id);
	}

	public Aviso update(Aviso aviso) {
		return this.repository.save(aviso);
	}

	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}

package me.alecio.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.alecio.backend.models.Roteiro;
import me.alecio.backend.repository.RoteiroRepository;

@Service
public class RoteiroService {

	@Autowired
	private RoteiroRepository repository;

	public Roteiro create(Roteiro roteiro) {
		return this.repository.save(roteiro);
	}

	public List<Roteiro> research() {
		return this.repository.findAll();
	}

	public Optional<Roteiro> research(Long id) {
		return this.repository.findById(id);
	}

	public Roteiro update(Roteiro roteiro) {
		return this.repository.save(roteiro);
	}

	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}
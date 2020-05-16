package me.alecio.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.alecio.backend.models.Sugestoes;
import me.alecio.backend.repository.SugestoesRepository;

@Service
public class SugestoesService {
	@Autowired
	private SugestoesRepository repository;

	public Sugestoes create(Sugestoes sugestoes) {
		return repository.save(sugestoes);
	}

	public List<Sugestoes> research() {
		return repository.findAll();
	}

	public Optional<Sugestoes> research(Long id) {
		return repository.findById(id);
	}

	public Sugestoes update(Sugestoes sugestoes) {
		return repository.save(sugestoes);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}
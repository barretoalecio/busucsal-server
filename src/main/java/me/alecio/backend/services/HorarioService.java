package me.alecio.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.alecio.backend.models.Horario;
import me.alecio.backend.repository.HorarioRepository;

@Service
public class HorarioService {
	@Autowired
	private HorarioRepository repository;
	
	public Horario create(Horario horario) {
		return this.repository.save(horario);
	}
	
	public Optional<Horario> research(Long id) {
		return this.repository.findById(id);
	}
	
	public List<Horario> research() {
		return this.repository.findAll();
	}
	
	public Horario update(Horario horario) {
		return this.repository.save(horario);
	}
	
	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}
package me.alecio.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.alecio.backend.models.Usuario;
import me.alecio.backend.repository.UsuarioRepository;


@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Usuario create(Usuario usuario) {
		return this.repository.save(usuario);
	}

	public List<Usuario> research() {
		return this.repository.findAll();
	}

	public Optional<Usuario> research(Long id) {
		return this.repository.findById(id);
	}

	public Usuario update(Usuario usuario) {
		return this.repository.save(usuario);
	}

	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}
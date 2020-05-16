package me.alecio.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.alecio.backend.models.Usuario;
import me.alecio.backend.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> index() {
		return ResponseEntity.ok().body(this.service.research());
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<Optional<Usuario>> show(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok().body(this.service.research(id));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Usuario> store(@RequestBody Usuario usuario) {
		return ResponseEntity.ok().body(this.service.create(usuario));
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	public ResponseEntity<Usuario> update(@PathVariable(name = "id") Long id, @RequestBody Usuario usuario) {
		usuario.setId(id);
		return ResponseEntity.ok().body(this.service.update(usuario));
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<String> destroy(@PathVariable(name = "id") Long id) {
		this.service.delete(id);
		return ResponseEntity.ok("Success");
	}
}
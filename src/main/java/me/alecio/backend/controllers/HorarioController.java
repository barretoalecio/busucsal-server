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

import me.alecio.backend.models.Horario;
import me.alecio.backend.services.HorarioService;

@RestController
@RequestMapping(value = "/horarios")
public class HorarioController {
	@Autowired
	private HorarioService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Horario> store(@RequestBody Horario horario) {
		return ResponseEntity.ok().body(this.service.create(horario));
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Horario>> index() {
		return ResponseEntity.ok().body(this.service.research());
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<Optional<Horario>> show(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok().body(this.service.research(id));
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	public ResponseEntity<Horario> update(@RequestBody Horario horario, @PathVariable(name = "id") Long id) {
		horario.setId(id);
		return ResponseEntity.ok().body(this.service.update(horario));
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<String> destroy(@PathVariable(name = "id") Long id) {
		this.service.delete(id);
		return ResponseEntity.ok("SUCESS");
	}

}

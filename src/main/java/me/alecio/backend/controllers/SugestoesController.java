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

import me.alecio.backend.models.Sugestoes;
import me.alecio.backend.services.SugestoesService;

@RestController
@RequestMapping(value = "/sugestoes")
public class SugestoesController {
	@Autowired
	private SugestoesService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Sugestoes>> index() {
		return ResponseEntity.ok().body(service.research());
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<Optional<Sugestoes>> show(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok().body(service.research(id));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Sugestoes> store(@RequestBody Sugestoes sugestoes) {
		return ResponseEntity.ok().body(service.create(sugestoes));
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	public ResponseEntity<Sugestoes> update(@RequestBody Sugestoes sugestoes, @PathVariable(name = "id") Long id) {
		sugestoes.setId(id);
		return ResponseEntity.ok().body(service.update(sugestoes));
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<String> destroy(@PathVariable(name = "id") Long id) {
		service.delete(id);
		return ResponseEntity.ok("Success");
	}
}
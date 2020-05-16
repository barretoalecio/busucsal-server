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

import me.alecio.backend.models.Roteiro;
import me.alecio.backend.services.RoteiroService;

@RestController
@RequestMapping(value = "/roteiros")
public class RoteiroController {

	@Autowired
	private RoteiroService service;
	@RequestMapping(method = RequestMethod.GET)

	public ResponseEntity<List<Roteiro>> index() {
		List<Roteiro> roteiros = this.service.research();
		return ResponseEntity.ok().body(roteiros);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<Optional<Roteiro>> show(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok().body(this.service.research(id));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Roteiro> store(@RequestBody Roteiro roteiro) {
		return ResponseEntity.ok().body(this.service.create(roteiro));
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	public ResponseEntity<Roteiro> update(@PathVariable(name = "id") Long id, @RequestBody Roteiro roteiro) {
		roteiro.setId(id);
		return ResponseEntity.ok().body(this.service.update(roteiro));
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<String> destroy(@PathVariable(name = "id") Long id) {
		this.service.delete(id);
		return ResponseEntity.ok("Sucess");
	}
}
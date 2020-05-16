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

import me.alecio.backend.models.Aviso;
import me.alecio.backend.services.AvisoService;

@RestController
@RequestMapping(value = "/avisos")
public class AvisoController {

	@Autowired
	private AvisoService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Aviso>> index() {
		List<Aviso> avisos = this.service.research();
		return ResponseEntity.ok().body(avisos);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<Optional<Aviso>> show(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok().body(this.service.research(id));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Aviso> store(@RequestBody Aviso aviso) {
		return ResponseEntity.ok().body(this.service.create(aviso));
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	public ResponseEntity<Aviso> update(@PathVariable(name = "id") Long id, @RequestBody Aviso aviso) {
		aviso.setId(id);
		return ResponseEntity.ok().body(this.service.update(aviso));
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<String> destroy(@PathVariable(name = "id") Long id) {
		this.service.delete(id);
		return ResponseEntity.ok("Success");
	}
}
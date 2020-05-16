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

import me.alecio.backend.models.StatusBusucsal;
import me.alecio.backend.services.StatusBusucsalService;

@RestController
@RequestMapping(value = "/status")
public class StatusBusucsalController {

	@Autowired
	private StatusBusucsalService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<StatusBusucsal>> index() {
		List<StatusBusucsal> status = this.service.research();
		return ResponseEntity.ok().body(status);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<Optional<StatusBusucsal>> show(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok().body(this.service.research(id));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<StatusBusucsal> store(@RequestBody StatusBusucsal statusBusucsal) {
		return ResponseEntity.ok().body(this.service.create(statusBusucsal));
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	public ResponseEntity<StatusBusucsal> update(@PathVariable(name = "id") Long id,
			@RequestBody StatusBusucsal statusBusucsal) {
		statusBusucsal.setId(id);
		return ResponseEntity.ok().body(this.service.update(statusBusucsal));
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
		this.service.delete(id);
		return ResponseEntity.ok("Sucess");
	}
}
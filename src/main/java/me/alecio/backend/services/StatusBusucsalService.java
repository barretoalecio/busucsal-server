package me.alecio.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.alecio.backend.models.StatusBusucsal;
import me.alecio.backend.repository.StatusBusucsalRepository;

@Service
public class StatusBusucsalService {

	@Autowired
	private StatusBusucsalRepository repository;

	public StatusBusucsal create(StatusBusucsal statusBusucsal) {
		return this.repository.save(statusBusucsal);
	}

	public List<StatusBusucsal> research() {
		return this.repository.findAll();
	}

		public Optional<StatusBusucsal> research(Long id) {
		return this.repository.findById(id);
	}

	public StatusBusucsal update(StatusBusucsal statusBusucsal) {
		return this.repository.save(statusBusucsal);
	}

	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}
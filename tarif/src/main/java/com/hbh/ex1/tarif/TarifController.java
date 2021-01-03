package com.hbh.ex1.tarif;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hbh.ex1.tarif.Tarif;
import com.hbh.ex1.tarif.TarifNotFoundException;

@RestController
public class TarifController {

	private final TarifRepository repository;

	TarifController(TarifRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/tarifs")
	List<Tarif> all() {
		return repository.findAll();
	}

	@PostMapping("/tarifs")
	Tarif newTarif(@RequestBody Tarif newTarif) {
		return repository.save(newTarif);
	}

	@GetMapping("/tarifs/{id}")
	Tarif one(@PathVariable Long id) {

		return repository.findById(id).orElseThrow(() -> new TarifNotFoundException(id));
	}

	@PutMapping("/tarifs/{id}")
	Tarif replaceTarif(@RequestBody Tarif newTarif, @PathVariable Long id) {

		return repository.findById(id).map(tarif -> {
			tarif.setTarifName(newTarif.getTarifName());
			return repository.save(tarif);
		}).orElseGet(() -> {
			newTarif.setId(id);
			return repository.save(newTarif);
		});
	}

	@DeleteMapping("/tarifs/{id}")
	void deleteTarif(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@GetMapping("/tarifs/name/{tarifName}")
	Tarif oneByName(@PathVariable String tarifName) {
		Tarif sample = new Tarif();
		sample.setTarifName(tarifName);

		return repository.findOne(Example.of(sample)).orElseThrow(() -> new TarifNotFoundException(tarifName));
	}
}

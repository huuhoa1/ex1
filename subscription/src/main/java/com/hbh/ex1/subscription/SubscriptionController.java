package com.hbh.ex1.subscription;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SubscriptionController {

	private final SubscriptionRepository repository;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private TarifService tarifService;

	SubscriptionController(SubscriptionRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/subscriptions")
	List<Subscription> all() {
		return repository.findAll();
	}

	@PostMapping("/subscriptions")
	Subscription newSubscription(@RequestBody Subscription newSubscription) throws CustomerNotFoundException {

		String customerName = newSubscription.getCustomerName();
		customerService.testMethod();
		String tarifName = newSubscription.getTarifName();
		tarifService.testMethod();
		// check if customer and tarif exist before creating subscription
		if ( ( customerService.checkCustomerName(customerName).isPresent() ) &&  ( tarifService.checkTarifName(tarifName).isPresent() ) ) {
			return repository.save(newSubscription);
		} else {
			throw new SubscriptionCouldNotBeCreatedException("customerName or tarifName does not exist!");
		}
	}

	@GetMapping("/subscriptions/{id}")
	Subscription one(@PathVariable Long id) {

		return repository.findById(id).orElseThrow(() -> new SubscriptionNotFoundException(id));
	}

	@PutMapping("/subscriptions/{id}")
	Subscription replaceSubscription(@RequestBody Subscription newSubscription, @PathVariable Long id) {

		return repository.findById(id).map(subscription -> {
			subscription.setCustomerName(newSubscription.getCustomerName());
			subscription.setTarifName(newSubscription.getTarifName());
			return repository.save(subscription);
		}).orElseGet(() -> {
			newSubscription.setId(id);
			return repository.save(newSubscription);
		});
	}

	@DeleteMapping("/subscriptions/{id}")
	void deleteSubscription(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@GetMapping("/subscriptions/customerName/{customerName}")
	Subscription oneByName(@PathVariable String customerName) {
		Subscription sample = new Subscription();
		sample.setCustomerName(customerName);
		return repository.findByCustomerName(customerName).orElseThrow(() -> new SubscriptionNotFoundException(customerName));

		//return repository.findOne(Example.of(sample)).orElseThrow(() -> new SubscriptionNotFoundException(customerName));
	}
}

package com.hbh.ex1.subscription;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{
	
	Optional<Subscription> findByCustomerName(String customerName);

}

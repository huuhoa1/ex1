package com.hbh.ex1.subscription;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;


//testing controller SubscriptionController at the web layer; Tomcat server is not started
// service bean are not created and need to be mocked

@WebMvcTest(controllers = SubscriptionController.class)
public class SubscriptionControllerAPITest {

	@Autowired
	private MockMvc mockMvc; // given automatically by @WebMvcTest

	@MockBean
	private SubscriptionRepository subscriptionRepository;
	
	@MockBean
	private CustomerService customerService;
	
	@MockBean
	private TarifService tarifService;
	
	// Test section of controller @GetMapping("/subscriptions/customerName/{customerName}")
	@Test
	public void shouldReturnSubcription() throws Exception {
		Subscription subscription = new Subscription("Can Huynh", "tarifD");
		given(subscriptionRepository.findByCustomerName("Can Huynh")).willReturn(Optional.of(subscription));
		mockMvc.perform(get("/subscriptions/customerName/Can Huynh")).andDo(print());
		mockMvc.perform(get("/subscriptions/customerName/Can Huynh")).andExpect(jsonPath(".customerName").value("Can Huynh"))
			.andExpect(status().is2xxSuccessful());
		
	}


}

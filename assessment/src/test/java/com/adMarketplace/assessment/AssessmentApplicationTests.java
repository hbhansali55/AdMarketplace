package com.adMarketplace.assessment;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.adMarketplace.service.Connections;

@RunWith(SpringRunner.class)
@SpringBootTest
class AssessmentApplicationTests {

	//Test positive scenario, new york and chicago are connected to each other. should return true
	@Test
	void testPositiveCase() {
		
		try(MockedStatic<Connections> utilities = Mockito.mockStatic(Connections.class)) {
			utilities.when(() -> Connections.getConnection("Chicago", "New York", "C:\\Users\\grish\\eclipse-workspace\\adMarketplaceAssessment\\src\\connected.txt"))
				.thenReturn(true);
			
			assertThat(Connections.getConnection("Chicago", "New York", "C:\\Users\\grish\\eclipse-workspace\\adMarketplaceAssessment\\src\\connected.txt")).isEqualTo(true);
			
		}
	}
	
	//Test negative scenario, seattle and chicago are not connected to each other via anything. should return false
	@Test
	void testNegativeCase() {
		
		try(MockedStatic<Connections> utilities = Mockito.mockStatic(Connections.class)) {
			utilities.when(() -> Connections.getConnection("Seattle", "Chicago", "C:\\Users\\grish\\eclipse-workspace\\adMarketplaceAssessment\\src\\connected.txt"))
				.thenReturn(false);
			
			assertThat(Connections.getConnection("Seattle", "Chicago", "C:\\Users\\grish\\eclipse-workspace\\adMarketplaceAssessment\\src\\connected.txt")).isEqualTo(false);
			
		}
	}

}

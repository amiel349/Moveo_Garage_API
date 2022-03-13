package com.example.restservice;

import com.example.restservice.Service.GarageService;
import com.example.restservice.controller.VehicleController;
import com.example.restservice.exceptions.ApiRequestExceptions;
import com.example.restservice.model.Vehicle;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Some basics tests
 *
 */
//@SpringBootTest
@WebMvcTest(VehicleController.class)
class RestServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private GarageService garageService;

	@Test
	public void shouldReturnAllVehicles() throws Exception {
		when(garageService.selectAllVehicles())
				.thenReturn(List.of(new Vehicle("Ferrari", 123,50,31,32),
						new Vehicle("Bugatti", 456,78,30,32)));

		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/api/1.0/vehicle"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(2))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].modelName").value("Ferrari"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].licenseNumber").value(123))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].energyPercentage").value(50))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].tirePressure").value(31))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].maxTirePressure").value(32))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].modelName").value("Bugatti"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].licenseNumber").value(456))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].energyPercentage").value(78))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].tirePressure").value(30))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].maxTirePressure").value(32));
	}
	@Test
	public void shouldFindVehicleByLIcenseNumber() {
		Vehicle vehicle = new Vehicle("Ferrari", 123,50,31,32);
		Mockito.when(garageService.retrieveVehicleByLicense(123)).thenReturn(vehicle);
		Assertions.assertThat(vehicle.getLicenseNumber()).isEqualTo(123);

	}
	@Test
	public void shouldReturn400WhenVehicleIsNotFound() throws Exception {
		when(garageService.retrieveVehicleByLicense(789))
				.thenThrow(new ApiRequestExceptions("Vehicle doesn't exists"));;

		this.mockMvc
				.perform(get("/api/1.0/vehicle/789"))
				.andExpect(status().isBadRequest());
	}
}

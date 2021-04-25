package com.ocr.paybuddy.ut.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.ocr.paybuddy.dto.UserDto;
import com.ocr.paybuddy.service.UserService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	UserService userService;

	UserDto userTest1 = new UserDto(1, "John", "Doe");
	UserDto userTest2 = new UserDto(2, "Iron", "Man");
	List<UserDto> listConnectionsTest = new ArrayList<>();

	public void testGetConnections() throws Exception {
		// Given
		listConnectionsTest.add(userTest1);
		listConnectionsTest.add(userTest2);

		// When
		// Simulation du comportement du service de requête get
		Mockito.when(userService.getConnections(1)).thenReturn(listConnectionsTest);
		// Then
		// Vérification du status de la réponse (200) de la requête
		mockMvc.perform(get("/connections")).andExpect(status().isOk());
		// Vérifie que le bon service a été appelé
		Mockito.verify(userService, Mockito.times(1)).getConnections(1);
		Assertions.assertEquals(2, listConnectionsTest.size());
	}

}

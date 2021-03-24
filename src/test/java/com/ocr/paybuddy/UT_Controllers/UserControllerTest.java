package com.ocr.paybuddy.UT_Controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.ocr.paybuddy.model.User;
import com.ocr.paybuddy.service.UserService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	UserService userService;

	User userTest1 = new User("Simon", "Dubourg");
	User userTest2 = new User("Didier", "Dubourg");
	List<User> listConnectionsTest = new ArrayList<>();

	@Test
	public void testGetConnections() throws Exception {
		// Given
		listConnectionsTest.add(userTest1);
		listConnectionsTest.add(userTest2);
		// When
		// Simulation du comportement du service de requête get
		Mockito.when(userService.findAll()).thenReturn(listConnectionsTest);
		// Then
		// Vérification du status de la réponse (200) de la requête
		mockMvc.perform(get("/connections")).andExpect(status().isOk());
		// Vérifie que le bon service a été appelé
		Mockito.verify(userService, Mockito.times(1)).findAll();

	}

	@Test
	public void testCreateConnection() throws Exception {
		// GIven

		// When

		// Then
	}

	@Test
	public void testFindUserByEmailInConnections(String email) throws Exception {
		// GIven

		// When

		// Then
	}

	@Test
	public void testSendMoneyToBuddy() throws Exception {
		// GIven

		// When

		// Then
	}

}

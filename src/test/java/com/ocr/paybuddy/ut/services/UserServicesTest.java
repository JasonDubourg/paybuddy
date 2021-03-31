package com.ocr.paybuddy.ut.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ocr.paybuddy.model.User;
import com.ocr.paybuddy.service.UserService;

public class UserServicesTest {

	@MockBean
	UserService userService;

	List<User> listConnectionsTest = new ArrayList<>();

	@BeforeEach
	public void paramTest() {
		User userTest1 = new User("Simon", "Dubourg");
		User userTest2 = new User("Didier", "Dubourg");

		listConnectionsTest.add(userTest1);
		listConnectionsTest.add(userTest2);
	}

	@Test
	public void testGetConnectionsFromUserList() {
		// GIVEN
		int id = 1;
		// WHEN
		when(userService.getConnectionsFromUserList(id)).thenReturn(listConnectionsTest);
		// THEN
		Assertions.assertEquals(2, listConnectionsTest.size());
	}

}

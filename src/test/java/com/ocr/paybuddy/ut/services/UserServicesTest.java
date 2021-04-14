package com.ocr.paybuddy.ut.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ocr.paybuddy.dto.UserDto;
import com.ocr.paybuddy.service.UserService;

public class UserServicesTest {

	@MockBean
	UserService userService;

	List<UserDto> listConnectionsTest = new ArrayList<>();

	// @BeforeEach
	public void paramTest() {
		UserDto userTest1 = new UserDto(1, "John", "Doe");
		UserDto userTest2 = new UserDto(2, "Iron", "Man");
		listConnectionsTest.add(userTest1);
		listConnectionsTest.add(userTest2);
	}

	public void testGetConnectionsFromUserList() {
		// GIVEN
		int id = 1;
		// WHEN
		when(userService.getConnections(id)).thenReturn(listConnectionsTest);
		// THEN
		Assertions.assertEquals(2, listConnectionsTest.size());
	}

}

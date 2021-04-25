package com.ocr.paybuddy.ut.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
public class UserServicesTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	UserService userService;

	UserDto userTest1 = new UserDto(1, "John", "Doe");
	UserDto userTest2 = new UserDto(2, "Iron", "Man");

	List<UserDto> listConnectionsTest = new ArrayList<>();

	@Test
	public void testGetConnectionsFromUserList() throws Exception {
		// GIVEN
		listConnectionsTest.add(userTest1);
		listConnectionsTest.add(userTest2);
		// WHEN
		Mockito.when(userService.getConnections(1)).thenReturn(listConnectionsTest);
		// THEN
		Assertions.assertEquals(2, listConnectionsTest.size());
	}

}

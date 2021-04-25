package com.ocr.paybuddy.integration;

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

import com.ocr.paybuddy.dao.UserDaoImpl;
import com.ocr.paybuddy.model.User;
import com.ocr.paybuddy.service.UserService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceTest {

	@Autowired
	UserService userServiceTest;

	@MockBean
	UserDaoImpl userDaoImplMock;

	User userTest1 = new User("Simon", "Dubourg");
	User userTest2 = new User("Didier", "Dubourg");
	List<User> listConnectionsTest = new ArrayList<>();

	@Test
	public void testGetConnectionsFromUserList() {
		// GIVEN
		int userID = 1;
		listConnectionsTest.add(userTest1);
		listConnectionsTest.add(userTest2);
		// WHEN
		Mockito.when(userDaoImplMock.getConnections(userID)).thenReturn(listConnectionsTest);
		// THEN
		Assertions.assertEquals(2, listConnectionsTest.size());
	}
}

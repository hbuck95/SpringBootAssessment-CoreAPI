package com.bae.rest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.bae.business.CoreServiceImpl;
import com.bae.persistence.domain.User;

@RunWith(SpringRunner.class)
public class CoreControllerTest {
	private static final User MOCK_USER_A = new User(1, "Fred", 1);
	private static final User MOCK_USER_B = new User(2, "Bob", 2);
	private static final String MOCK_CREATE_USER_RESPONSE = "User created!";

	@Mock
	private CoreServiceImpl service;

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private CoreController controller;

	private List<User> userList;

	@Before
	public void setup() {
		userList = new ArrayList<>();
	}

	@Test
	public void getAllUsersTest() {
		userList.add(MOCK_USER_A);
		userList.add(MOCK_USER_B);

		Mockito.when(service.getAllUsers()).thenReturn(userList);

		List<User> res = controller.getAllUsers();

		Mockito.verify(service).getAllUsers();
		assertEquals(userList, res);
	}

	@Test
	public void createUserTest() {
		Mockito.when(service.createUser(MOCK_USER_A)).thenReturn(MOCK_CREATE_USER_RESPONSE);
		String res = controller.createUser(MOCK_USER_A);
		Mockito.verify(service).createUser(MOCK_USER_A);
		assertEquals(MOCK_CREATE_USER_RESPONSE, res);
	}

	@Test
	public void findMemberByIdTest() {
		Mockito.when(service.findByMemberId(1)).thenReturn(MOCK_USER_A);
		User user = controller.findByMemberId(1);
		Mockito.verify(service).findByMemberId(1);
		assertEquals(user, MOCK_USER_A);
		assertEquals(1, MOCK_USER_A.getMemberId());
	}

}

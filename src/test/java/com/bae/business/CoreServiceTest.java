package com.bae.business;

import java.util.List;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.bae.persistence.domain.User;

@RunWith(SpringRunner.class)
public class CoreServiceTest {
	private static final User MOCK_USER_A = new User(1, "Fred", 1);
	private static final User MOCK_USER_B = new User(2, "Bob", 2);
	private static final String MOCK_CREATE_USER_RESPONSE = "User created!";
	private static final String MOCK_USERCREATE_URL = "http://localhost:8080/user/create";
	private static final String MOCK_GETALLUSER_URL = "http://localhost:8080/user/all";

	@InjectMocks
	private CoreServiceImpl service;

	@Mock
	private RestTemplate template;

	private List<User> userList;

//	@Before
//	public void setup() {
//		userList = new ArrayList<>();
//	}

//	@Test
//	public void getAllUsersTest() {
//		userList.add(MOCK_USER_A);
//		userList.add(MOCK_USER_B);
//		HttpEntity<User> userEntity = new HttpEntity<>(MOCK_USER_A);
//
//		Mockito.when(template
//				.exchange(MOCK_GETALLUSER_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
//				}).getBody()).thenReturn(userList);
//
//		List<User> res = service.getAllUsers();
//
//		// Mockito.verify(service).getAllUsers();
//		assertEquals(userList, res);
//	}
//
//	@Test
//	public void findMemberByIdTest() {
//		Mockito.when(service.findByMemberId(1)).thenReturn(MOCK_USER_A);
//		User user = service.findByMemberId(1);
//		Mockito.verify(service).findByMemberId(1);
//		assertEquals(user, MOCK_USER_A);
//		assertEquals(1, MOCK_USER_A.getMemberId());
//	}

}

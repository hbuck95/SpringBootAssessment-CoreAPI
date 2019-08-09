package com.bae.business;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.bae.persistence.domain.User;

@Service
public class CoreServiceImpl implements CoreService {
	private RestTemplate template;

	private static final String POKE_API_MICROSERVICE_URL = "http://localhost:8081/poke/";
	private static final String USER_API_MICROSERVICE_URL = "http://localhost:8080/user/";

	public CoreServiceImpl(RestTemplate template) {
		this.template = template;
	}

	@Override
	public String findPokemonByName(int memberId, String pokemon) {
		ResponseEntity<String> pokeString = template.exchange(
				String.format("%s/findbyname/%s/%s", POKE_API_MICROSERVICE_URL, memberId, pokemon), HttpMethod.GET,
				null, String.class);

		return pokeString.getBody();
	}

	@Override
	public String findPokemonById(int memberId, int pokeId) {
		ResponseEntity<String> pokeString = template.exchange(
				String.format("%s/findbyid/%s/%s", POKE_API_MICROSERVICE_URL, memberId, pokeId), HttpMethod.GET, null,
				String.class);

		return pokeString.getBody();
	}

	@Override
	public String createUser(@RequestBody User user) {
		System.out.println(USER_API_MICROSERVICE_URL + "create");
		HttpEntity<User> userEntity = new HttpEntity<>(user);
		ResponseEntity<String> userString = template.exchange(USER_API_MICROSERVICE_URL + "create", HttpMethod.POST,
				userEntity, String.class);
		return "User created!";
	}

	@Override
	public List<User> getAllUsers() {
		ResponseEntity<List<User>> users = template.exchange(USER_API_MICROSERVICE_URL + "all", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<User>>() {
				});
		return users.getBody();
	}

	@Override
	public User findByMemberId(int memberId) {
		ResponseEntity<User> user = template.exchange(USER_API_MICROSERVICE_URL + "memberid/" + memberId,
				HttpMethod.GET, null, User.class);
		return user.getBody();
	}

}

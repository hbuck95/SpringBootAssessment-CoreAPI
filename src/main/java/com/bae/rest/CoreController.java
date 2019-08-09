package com.bae.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.business.CoreService;
import com.bae.persistence.domain.User;

@RestController
@RequestMapping("/")
public class CoreController {
	private CoreService service;

	@Autowired
	public CoreController(CoreService service) {
		this.service = service;
	}

	@GetMapping("/poke/name/{memberId}/{name}")
	public String findPokemonByName(@PathVariable("memberId") int memberId, @PathVariable("name") String pokemon) {
		return service.findPokemonByName(memberId, pokemon);
	}

	@GetMapping("/poke/id/{memberId}/{id}")
	public String findPokemonById(@PathVariable("memberId") int memberId, @PathVariable("id") int id) {
		return service.findPokemonById(memberId, id);
	}

	@GetMapping("/user/all")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}

	@GetMapping("/user/memberid/{id}")
	public User findByMemberId(@PathVariable("id") int id) {
		return service.findByMemberId(id);
	}

	@PostMapping("/user/create")
	public String createUser(@RequestBody User user) {
		// SentUser u = new SentUser(user);
		// sendToQueue(u);
		return service.createUser(user);
	}

}

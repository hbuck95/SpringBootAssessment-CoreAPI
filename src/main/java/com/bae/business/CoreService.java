package com.bae.business;

import java.util.List;

import com.bae.persistence.domain.User;

public interface CoreService {

	public String findPokemonByName(int memberId, String pokemon);

	public String findPokemonById(int memberId, int pokeId);

	public String createUser(User user);

	public List<User> getAllUsers();

	public User findByMemberId(int memberId);

}

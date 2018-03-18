package com.uniovi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Friendship;
import com.uniovi.entities.User;


public interface FriendshipRepository extends CrudRepository<Friendship, Long> {

	@Query("select f from Friendship f where f.user=?1 or f.friend=?1")
	Page<Friendship> findByUser(Pageable pageable, User loggedInUser);

}
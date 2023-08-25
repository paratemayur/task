package com.voteapp.repository;

import com.voteapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String username);

    boolean existsByUserName(String username);
}

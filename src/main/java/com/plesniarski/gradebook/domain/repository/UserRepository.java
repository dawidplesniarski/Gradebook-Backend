package com.plesniarski.gradebook.domain.repository;

import com.plesniarski.gradebook.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);

    @Query("SELECT u.password from User u WHERE u.login = :userLogin ")
    String getPassword(String userLogin);
    void deleteUserByUserId(Long id);
}

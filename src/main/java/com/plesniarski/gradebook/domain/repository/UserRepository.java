package com.plesniarski.gradebook.domain.repository;

import com.plesniarski.gradebook.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);
    List<User> findAllByCourseContainsIgnoreCase(String course);
    @Query("SELECT u.course FROM User u")
    List<String> findCourses();
}

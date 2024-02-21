package com.testprojects.repository;

import com.testprojects.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<User,Long> {
}

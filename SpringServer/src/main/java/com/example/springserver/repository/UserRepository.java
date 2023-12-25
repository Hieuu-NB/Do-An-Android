package com.example.springserver.repository;

import com.example.springserver.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users WHERE  tai_khoan = :username and mat_khau = :password  order by id", nativeQuery = true)
    User findUser(String username, String password);
}

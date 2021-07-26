package com.cgi.RestAPI.repository;

import com.cgi.RestAPI.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findById(int id);
    List<User> findByName(String name);
    List<User> getByAge(int age);
    List<User> getByGender(String gender);
}

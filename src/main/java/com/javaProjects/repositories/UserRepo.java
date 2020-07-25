package com.javaProjects.repositories;

import org.springframework.data.repository.CrudRepository;

import com.javaProjects.models.User;

public interface UserRepo extends CrudRepository<User,Long>{// User comes from user class

}

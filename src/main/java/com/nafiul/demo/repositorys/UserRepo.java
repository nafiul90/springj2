package com.nafiul.demo.repositorys;

import com.nafiul.demo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,String> {
}

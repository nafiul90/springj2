package com.nafiul.demo.repositorys;

import com.nafiul.demo.model.Phone;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepo extends CrudRepository<Phone,Integer> {
}

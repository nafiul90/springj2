package com.nafiul.demo.repositorys;

import com.nafiul.demo.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepo extends CrudRepository<Address,Integer> {
}

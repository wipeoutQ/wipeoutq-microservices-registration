package com.wipeoutq.registration.repository;

import com.wipeoutq.registration.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {

    String findByMobile(String mobile);

}

package com.wipeoutq.registration.service;

import com.wipeoutq.registration.entity.User;

import java.util.List;

public interface UserService {

    User add(User user);

    User findById(String id);

    User update(String id, User user);

    String deleteById(String id);

   boolean findByMobile(String mobile);
}

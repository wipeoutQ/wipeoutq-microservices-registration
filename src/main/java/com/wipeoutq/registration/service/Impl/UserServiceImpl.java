package com.wipeoutq.registration.service.Impl;

import com.wipeoutq.registration.entity.User;
import com.wipeoutq.registration.repository.UserRepository;
import com.wipeoutq.registration.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private BeanUtils BeanMapper;

    public User add(User user) {
        return userRepository.save(user);

    }

    @Override
    public User findById(String id) {
        Optional<User> optional = this.userRepository.findById(id);
        return optional.get();
    }

    @Override
    public User update(String id, User request) {

        try {
            User savedUser = this.findById(id);
            savedUser.setName(request.getName());
            savedUser.setEmail(request.getEmail());
            savedUser.setMobile(request.getMobile());
            savedUser = this.userRepository.save(savedUser);
            return savedUser;
        } catch (Exception exception) {
            throw exception;
        }
    }

    @Override
    public String deleteById(String id) {
        this.userRepository.deleteById(id);
        return "deleted successfully";
    }

    @Override
    public boolean findByMobile(String mobile) {
        String data = userRepository.findByMobile(mobile);
        if(data==null){
            return false;
        }
        return true;
    }

}
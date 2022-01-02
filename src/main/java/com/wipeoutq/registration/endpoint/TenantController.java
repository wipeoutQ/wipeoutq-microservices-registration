package com.wipeoutq.registration.endpoint;

import com.wipeoutq.registration.dto.Response;
import com.wipeoutq.registration.entity.User;
import com.wipeoutq.registration.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("Registration")
public class TenantController {

    @Autowired
    private UserService userService;

    @PostMapping("add")
   public ResponseEntity<Response> add(@RequestBody User user){
        log.info("Registration user called.");
        User Create = this.userService.add(user);

        Response response = new Response();
        response.setData(Create);
        response.succeed();
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("get/{id}")
    public ResponseEntity<Response> find(@PathVariable String id){
        log.info("[findbyId] id: '{}' called.", id);
        User user = this.userService.findById(id);
        Response response = new Response();
        response.setData(user);
        response.succeed();
        return ResponseEntity.ok(response);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Response> update(@PathVariable String id, @RequestBody User request){
        log.info("[updated]: user called update");
        User user = this.userService.update(id,request);
        Response response = new Response();
        response.setData(user);
        response.succeed();
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable String id) {
        log.info("[Deleted]: user called update");
        String data = this.userService.deleteById(id);
        return data;
    }

    @GetMapping("user")
    public ResponseEntity<Response> findbymobile(@RequestParam(required = false) String mobile){
        log.info("[get user list]: user called update");
        boolean data = this.userService.findByMobile(mobile);
        Response response = new Response();
        response.setData(data);
        response.succeed();
        return ResponseEntity.ok(response);

    }


}

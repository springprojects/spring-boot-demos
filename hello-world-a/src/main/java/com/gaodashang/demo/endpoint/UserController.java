package com.gaodashang.demo.endpoint;

import com.gaodashang.demo.domain.User;
import org.springframework.web.bind.annotation.*;

/**
 * comments.
 *
 * @author eva
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public User view(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        user.setName("gaodashang");
        return user;
    }

    @RequestMapping("/foo")
    @ResponseBody
    public String foo() {
        throw new IllegalArgumentException("Server error");
    }
}
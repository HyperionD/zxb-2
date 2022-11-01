package org.example.user;

import org.example.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/users")
    public Resp addUser(@RequestParam String account, @RequestParam String name, @RequestParam String password) {
        Resp res = new Resp();
        res.setCode(200);
        res.setMsg("success");

        User user = new User();
        user.setAccount(account);
        user.setName(name);
        user.setPassword(password);
        userRepo.save(user);

        res.setData(user);

        return res;
    }
}

package org.example.user;

import org.example.Resp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PersistenceContext
    private EntityManager em;

    @PostMapping("/users")
    public Resp addUser(@RequestBody User user) {
        Resp res = new Resp();
        res.setCode(200);
        res.setMsg("success");

        Date now = new Date();
        user.setCreateTime(now);

        try {
            userRepo.save(user);
        } catch (Exception e) {
            String msg = e.getMessage();
            res.setCode(500);
            res.setMsg(msg);
        }


        res.setData(user);

        return res;
    }
}

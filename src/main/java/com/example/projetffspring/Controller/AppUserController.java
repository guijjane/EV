package com.example.projetffspring.Controller;


import com.example.projetffspring.Model.AppUser;
import com.example.projetffspring.Model.SaveUserRequest;
import com.example.projetffspring.Service.AppUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/appusers")
@CrossOrigin("*")
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {

        this.appUserService = appUserService;
    }


    @PostMapping("/authenticate")
    public AppUser authenticate(@RequestParam(name = "username") String username,
                                @RequestParam(name = "password") String password) {
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        return appUserService.authenticate(username, password);
    }

    @PostMapping("/appusers/create")
    public AppUser createAppUser(@RequestBody SaveUserRequest appUser) {
        return appUserService.createUser(appUser.getUsername(),appUser.getPassword(), appUser.getIdRole());
    }

    @PostMapping
    public AppUser createUser(@RequestBody SaveUserRequest appUser) {
        return appUserService.saveAppUser(appUser);
    }


    @GetMapping("/{id}")
    public AppUser getAppUserById(@PathVariable Long id) {
        return appUserService.getAppUserById(id);
    }

    @GetMapping
    public List<AppUser> getAllAppUsers() {
        return appUserService.getAllAppUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteAppUserById(@PathVariable Long id) {
        appUserService.deleteAppUserById(id);
    }
}

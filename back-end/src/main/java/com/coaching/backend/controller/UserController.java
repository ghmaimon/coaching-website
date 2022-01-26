package com.coaching.backend.controller;

import com.coaching.backend.enumeration.Role;
import com.coaching.backend.model.Client;
import com.coaching.backend.model.Coach;
import com.coaching.backend.model.SuperUser;
import com.coaching.backend.security.JwtProperties;
import com.coaching.backend.service.ClientService;
import com.coaching.backend.service.CoachService;
import com.coaching.backend.service.SuperUserService;
import com.coaching.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class UserController {

    CoachService coachService;
    ClientService clientService;
    SuperUserService superUserService;
    UserService userService;

    public UserController(CoachService coachService, ClientService clientService,
                          SuperUserService superUserService, UserService userService) {
        this.coachService = coachService;
        this.clientService = clientService;
        this.superUserService = superUserService;
        this.userService = userService;
    }

    // create users:

    @PostMapping(path = "/create/coach",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Coach> createCoach(@RequestBody Coach coach) throws Throwable {
        coach.setRole(Role.COACH);
        return new ResponseEntity<>(
                coachService.createUser(coach),
                HttpStatus.CREATED
        );
    }

    @PostMapping(path = "/create/client",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> createClient(@RequestBody Client client) throws Throwable {
        client.setRole(Role.CLIENT);
        return new ResponseEntity<>(
                clientService.createUser(client),
                HttpStatus.CREATED
        );
    }

    @PostMapping(path = "/create/superuser",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuperUser> createSuperUser(@RequestBody SuperUser superUser) throws Throwable {
        superUser.setRole(Role.SUPERUSER);
        return new ResponseEntity<>(
                superUserService.createUser(superUser),
                HttpStatus.CREATED
        );
    }

    // list users

    @GetMapping(path = "/list/coach/all")
    public ResponseEntity<List<Coach>> listAllCoaches(){
        return new ResponseEntity<>(
                coachService.getAllUsers(),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/list/client/all")
    public ResponseEntity<List<Client>> listAllClients(){
        return new ResponseEntity<>(
                clientService.getAllUsers(),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/list/superuser/all")
    public ResponseEntity<List<SuperUser>> listAllSuperUsers(){
        return new ResponseEntity<>(
                superUserService.getAllUsers(),
                HttpStatus.OK
        );
    }

    // delete users:

    @DeleteMapping(path = "/delete/ByEmail")
    public ResponseEntity<Void> deleteUserByEmail(@RequestHeader String email) {
        userService.deleteUserWithEmail(email);
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/delete/ById/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable long id) {
        userService.deleteUserWithId(id);
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Void> deleteCurrentUser(@RequestHeader("Authorization") String jwtToken) {
        if (jwtToken == null || !jwtToken.startsWith(JwtProperties.TOKEN_PREFIX)){
            return new ResponseEntity<>(
                    HttpStatus.BAD_REQUEST
            );
        }
        return new ResponseEntity<>(
                userService.deleteUserWithToken(jwtToken)
        );
    }
}

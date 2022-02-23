package com.coaching.backend.controller.controller;

import com.coaching.backend.enumeration.Role;
import com.coaching.backend.model.*;
import com.coaching.backend.security.JwtChangePassword;
import com.coaching.backend.security.JwtProperties;
import com.coaching.backend.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.util.List;

@RestController
@RequestMapping("/api/account")
public class UserController {

    CoachService coachService;
    ClientService clientService;
    SuperUserService superUserService;
    UserService userService;

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

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
    public ResponseEntity<Coach> createCoach(@Valid @RequestBody Coach coach) throws Throwable {
        LOG.debug("new /create/coach request : "+coach.getEmail());
        coach.setRole(Role.COACH);
        return new ResponseEntity<>(
                coachService.createUser(coach),
                HttpStatus.CREATED
        );
    }

    @PostMapping(path = "/create/client",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> createClient(@Valid @RequestBody Client client) throws Throwable {
        client.setRole(Role.CLIENT);
        return new ResponseEntity<>(
                clientService.createUser(client),
                HttpStatus.CREATED
        );
    }

    @PostMapping(path = "/create/superuser",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuperUser> createSuperUser(@Valid @RequestBody SuperUser superUser) throws Throwable {
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
    public ResponseEntity<Void> deleteUserByEmail(@RequestHeader @Email(message = "must be an email") String email) {
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

    @PutMapping(path = "/changePassword")
    public ResponseEntity<Void> changePassword(@RequestBody JwtChangePassword jwtChangePassword,
                                               @RequestHeader("Authorization") String jwtToken) {
        return new ResponseEntity<>(
                userService.changePasswordFromToken(jwtToken, jwtChangePassword)
        );
    }

    @PutMapping(path = "/changePassword/{id}")
    public ResponseEntity<Void> changePasswordById(@RequestBody JwtChangePassword jwtChangePassword,
                                                   @PathVariable long id) {
        return new ResponseEntity<>(
                userService.changePasswordById(id, jwtChangePassword)
        );
    }

    @PostMapping(path = "/forgotPassword")
    public ResponseEntity<Void> forgotPassword(@RequestHeader String email) {
        return new ResponseEntity<>(
                userService.forgotPassword(email)
        );
    }
}

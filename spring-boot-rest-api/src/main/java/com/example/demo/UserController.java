package com.example.demo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  // GET /users -> returns all users
	@GetMapping("/users") 
	public ArrayList<User> users() throws IOException {
    JSONManager dataManager = new JSONManager();
    ArrayList<User> users = dataManager.users();
		return users;
	}

  // GET /users/:id -> return a single user
  @GetMapping("/users/{id}") 
	public ResponseEntity<User> user(@PathVariable int id, @RequestParam(value = "name", defaultValue = "World") String name) throws IOException {
    JSONManager dataManager = new JSONManager();
    ArrayList<User> users = dataManager.users();
    User foundUser = findUserById(users, id);
    
    if(foundUser != null){
      return ResponseEntity.ok(foundUser);
    } else {
      return ResponseEntity.notFound().build();
    }
	}

  // POST /users
  @PostMapping(path = "users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> create(@RequestBody User newUser) throws IOException{
    JSONManager dataManager = new JSONManager();
    ArrayList<User> users = dataManager.users();

    newUser.setId(users.size() + 1);
    users.add(newUser);
    // User user = new User(users.size() + 1, newUser.getName(), newUser.getEmail(), newUser.getRoles(), newUser.isAdmin());
    // users.add(user);

    dataManager.writeJsonFile("users.json", users);
    return ResponseEntity.ok(newUser);
  }


  public static User findUserById(List<User> users, int targetId) {
    for (User user : users) {
      if (user.getId() == targetId) {
        return user;
      }
    }
    return null; // User not found
  }
}
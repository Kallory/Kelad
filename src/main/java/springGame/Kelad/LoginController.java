package springGame.Kelad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // annotation allowing SpringBoot to register this class
@RequestMapping("/game")
public class LoginController {
    @Autowired
    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @PostMapping("/login")
    public ResponseEntity<String> handleLogin(@RequestBody LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            System.out.println("User: " + user.getUsername());
            return new ResponseEntity<>("Happily Logged in", HttpStatus.OK);
        } else {
            System.out.println("Invalid credentials");
            return new ResponseEntity<>("Invalid credentials", HttpStatus.FORBIDDEN);
        }
    }
}

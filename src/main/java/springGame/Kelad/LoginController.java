package springGame.Kelad;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // annotation allowing SpringBoot to register this class
@RequestMapping("/game")
public class LoginController {
    private String username = "UserJoe";
    private String password = "star12356";

    @PostMapping("/login")
    public ResponseEntity<String> handleLogin(@RequestBody LoginRequest loginRequest) {
        System.out.println("Username: " + loginRequest.getUsername());
        System.out.println("Password: " + loginRequest.getPassword());
        if (loginRequest.getUsername().equals(username) && loginRequest.getPassword().equals(password)) {
            return new ResponseEntity<>("Happily Logged in", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.FORBIDDEN);
        }
    }
}

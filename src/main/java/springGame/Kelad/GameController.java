package springGame.Kelad;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/game")
public class GameController {

    @GetMapping("/start")
    public ResponseEntity<List<Country>> startGame() {
        List<Country> countries = IntStream.range(0, 10).mapToObj(i -> Country.generateRandom()).collect(Collectors.toList());
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }
}



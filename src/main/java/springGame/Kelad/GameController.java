package springGame.Kelad;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // annotation allowing SpringBoot to register this class
@RequestMapping("/game")
// used to forward incoming HTTP requests to the correct method in this GameController.Java file
public class GameController {

    @GetMapping("/start")
    public ResponseEntity<List<Country>> startGame() {
//        List<Country> countries = IntStream.range(0, 10).mapToObj(i -> Country.generateRandom()).collect(Collectors.toList());

        // Create an IntStream ranging from 0 to 10
        IntStream intStream = IntStream.range(0, 10);

        // lambda equivalent of below anon class
        IntFunction<Country> generateRandomCountry = value -> Country.generateRandom();
        // Create a new anonymous class of type IntFunction (a functional interface)
        // that overrides the apply method to generate a random Country
//        IntFunction<Country> generateRandomCountry = new IntFunction<Country>() {
//
//            @Override
        // apply() is part of IntFunction and is automatically called when we call mapToObj on this object.
        // it's also called without being explicitly defined in the lambda equivalent above.
//            public Country apply(int value) {
//                return Country.generateRandom();
//            }
//        };

        // Use mapToObj to apply the generateRandomCountry function to each element in the IntStream
        /*
            We create a Stream that takes a generic type, which we decide is our self-defined Country class. We then call the static method mapToObj with our IntFunction<Country> generateRandomCountry. Underneath the hood, the apply function is being called allowing the generateRandom() function to be called. Thus, 10 random countries are created with random names.
         */
        Stream<Country> countryStream = intStream.mapToObj(generateRandomCountry);

        // Collect the resulting Stream into a List
        List<Country> countries = countryStream.collect(Collectors.toList());

        return new ResponseEntity<>(countries, HttpStatus.OK);
    }
}



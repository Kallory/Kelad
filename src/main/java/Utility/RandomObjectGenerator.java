package Utility;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomObjectGenerator<T> {

    private final Function<T, T> generatorFunction;

    public RandomObjectGenerator(Function<T, T> generatorFunction) {
        this.generatorFunction = generatorFunction;
    }

    public List<T> generateList(T parentObject, int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> generatorFunction.apply(parentObject))
                .collect(Collectors.toList());
    }
}
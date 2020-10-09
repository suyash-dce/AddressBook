import java.util.stream.Stream;

@FunctionalInterface
public interface SortingFunction {

	Stream<Collection> sort(Stream<Collection> input);
}

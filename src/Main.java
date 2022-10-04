import java.util.List;

public class Main {
  public static void main(String[] args) {
    final List<String> words = List.of("Hello", "World", "Core", "Java", "HelloWorld", "Java");

    final Filter filter = new Filter(words);
    filter.run();

    final SimpleReductions simpleReductions = new SimpleReductions(words);
    // simpleReductions.run();

    final OptionalType optionalType = new OptionalType(words);
    // optionalType.run();

    final CollectingResults collectingResults = new CollectingResults(words);
    // collectingResults.run();

    final CollectingIntoMaps collectingIntoMaps = new CollectingIntoMaps();
    // collectingIntoMaps.run();

    final GroupingAndPartitioning groupingAndPartitioning = new GroupingAndPartitioning();
    // groupingAndPartitioning.run();

    final ReductionOperations reductionOperations = new ReductionOperations();
    // reductionOperations.run();

  }
}

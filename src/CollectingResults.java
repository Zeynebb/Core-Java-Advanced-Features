import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResults {

  private final List<String> words;

  public CollectingResults(List<String> words) {
    this.words = words;
  }

  public void run() {
    Utils.addHeader("forEach");
    // Stream içerisindeki değerlere erişmek için kullanılır.
    words.stream().map(String::toLowerCase).forEach(System.out::println);

    Utils.addHeader("toList");
    final List<Integer> toList = Stream.iterate(1, p -> p * 2).limit(4).toList();
    System.out.println(toList);
    // toList() metodu Java 16 sürümünde eklenmiştir
    // Önceki sürümlerde .collect(Collectors.toList()) metodu kullanılmaktadır.
    final List<Integer> toListCollect =
        Stream.iterate(1, p -> p * 2).limit(4).collect(Collectors.toList());

    Utils.addHeader("SummaryStatistics");
    final IntSummaryStatistics intSummaryStatistics =
        Stream.iterate(1, p -> p * 2).limit(4).collect(Collectors.summarizingInt(value -> value));
    System.out.println(intSummaryStatistics);

    Utils.addHeader("toArray");
    final Integer[] toArray = Stream.iterate(1, a -> a * 2).limit(4).toArray(Integer[]::new);
    for (Integer number : toArray) {
      System.out.println(number);
    }
  }
}

import java.util.List;
import java.util.Optional;

public class SimpleReductions {

  private final List<String> words;

  public SimpleReductions(List<String> words) {
    this.words = words;
  }

  public void run() {
    // Koşulu sağlayan ilk değeri bulmak için kullanılır.
    Utils.addHeader("findFirst");
    final Optional<String> first = words.stream().filter(s -> s.startsWith("J")).findFirst();
    System.out.println(first);

    // Koşulu sağlayan herhangi bir değeri bulmak için kullanılır.
    Utils.addHeader("findAny");
    Optional<String> findAny = words.parallelStream().filter(s -> s.startsWith("H")).findAny();
    System.out.println(findAny);

    // Koşulu sağlayan herhangi bir değer olup olmadığını bulmak için kullanılır.
    Utils.addHeader("anyMatch");
    boolean anyMatch = words.parallelStream().anyMatch(s -> s.startsWith("C"));
    System.out.println(anyMatch);
  }
}

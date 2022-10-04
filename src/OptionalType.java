import java.util.List;
import java.util.Optional;

public class OptionalType {

  private final List<String> words;

  public OptionalType(List<String> words) {
    this.words = words;
  }

  public void run() {
    // Java 8
    // İçerisinde değer olmadığında null yerine Optional.empty döndürür
    Utils.addHeader("orElse");
    final Optional<String> findAny =
        words.stream().parallel().filter(s -> s.startsWith("z")).findAny();
    System.out.println(findAny);
    System.out.println(findAny.orElse("Not Found"));

    Utils.addHeader("orElseGet");
    System.out.println(findAny.orElseGet(() -> words.get(3)));

    Utils.addHeader("orElseThrow");
    // System.out.println(findAny.orElseThrow(IllegalStateException::new));

    Utils.addHeader("ifPresent");
    final Optional<String> findAnyStartsWithJ =
        words.stream().parallel().filter(s -> s.startsWith("J")).findAny();
    findAny.ifPresent(System.out::println);
    findAnyStartsWithJ.ifPresent(System.out::println);

    Utils.addHeader("ifPresentOrElse");
    findAny.ifPresentOrElse(System.out::println, () -> System.out.println("Not Found"));
    findAnyStartsWithJ.ifPresentOrElse(System.out::println, () -> System.out.println("Not Found"));

    Utils.addHeader("map & filter");
    final Optional<String> mapAndFilter =
        findAnyStartsWithJ.filter(w -> w.length() > 2).map(String::toUpperCase);
    System.out.println(mapAndFilter);

    Utils.addHeader("or");
    final Optional<String> first = findAnyStartsWithJ.or(() -> mapAndFilter).stream().findFirst();
    System.out.println(first);

    Utils.addHeader("How Not to Work with Optional Values");
    // findAny optional değeri boş olduğu için get() metodu NoSuchElementException hatasını fırlatır
    // System.out.println(findAny.get());
    // optionalValue.orElseThrow().someMethod()
    // orElseThrow() metodu hata fırlatacağı için sonrasında yapılması istenilen işlem
    // yapılmayacaktır.

    Utils.addHeader("Creating Optional Value");
    // Optional.of() metodu null değer alamaz
    // Optional.ofNullable() metodu null değer aldığında boş bir Optional nesnesi döndürür.
    String nullValue = null;
    // final Optional<String> value = Optional.of(nullValue);
    final Optional<String> nullableValue = Optional.ofNullable(nullValue);
    System.out.println(nullableValue);
  }
}

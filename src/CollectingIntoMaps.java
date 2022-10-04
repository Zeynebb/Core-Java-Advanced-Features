import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingIntoMaps {

  private final Stream<Person> people;
  private final Stream<Person> people2;

  public CollectingIntoMaps() {
    people =
        Stream.of(
            new Person(1, "Zeyneb", "24"),
            new Person(2, "Eda", "25"),
            new Person(3, "Yılmaz", "26"));
    people2 = Stream.of(new Person(1, "Zeyneb", "24"), new Person(2, "Eda", "25"));
  }

  public void run() {
    Utils.addHeader("toMap");
    Map<Integer, String> idToName = people.collect(Collectors.toMap(Person::id, Person::name));
    System.out.println(idToName.get(1));

    Map<String, String> nameToAge = people2.collect(Collectors.toMap(Person::name, Person::age));
    System.out.println(nameToAge);
  }

  public record Person(int id, String name, String age) {}
}

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class GroupingAndPartitioning {

  private final Stream<Person> people;
  private final Stream<Person> people2;
  private final Stream<Person> people3;

  public GroupingAndPartitioning() {
    people =
        Stream.of(
            new Person(1, "Zeyneb", "24"),
            new Person(2, "Eda", "25"),
            new Person(3, "Yılmaz", "26"));
    people2 =
        Stream.of(
            new Person(1, "Zeyneb", "24"),
            new Person(2, "ZeynebEda", "25"),
            new Person(3, "Yılmaz", "26"));
    people3 =
        Stream.of(
            new Person(1, "Zeyneb", "24"),
            new Person(2, "ZeynebEda", "25"),
            new Person(3, "Yılmaz", "25"));
  }

  public void run() {
    Utils.addHeader("groupingBy");
    Map<String, List<Person>> groupingByName = people.collect(groupingBy(Person::name));
    System.out.println(groupingByName);

    Map<Boolean, List<Person>> partitioningByName =
        people2.collect(partitioningBy(z -> z.name.contains("Zeyneb")));
    System.out.println(partitioningByName);

    Utils.addHeader("counting");
    Map<String, Long> groupingByAge = people3.collect(groupingBy(Person::age, counting()));
    System.out.println(groupingByAge);
    // maxBy, minBy, collectingAndThen, mapping
  }

  public record Person(int id, String name, String age) {}
}

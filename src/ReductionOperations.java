import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ReductionOperations {

  private final List<Integer> values;

  public ReductionOperations() {
    values = Stream.iterate(1, a -> a * 2).limit(4).toList();
  }

  public void run() {
    System.out.println("Values: " + values);

    Utils.addHeader("reduce");
    Optional<Integer> sum = values.stream().reduce((x, y) -> x + y);
    System.out.println(sum);

    // identity değeri atandığında stream boş olsa dahi identity değeri döneceği için Optional kullanımına gerek kalmaz
    Integer sum2 = values.stream().reduce(0, (x, y) -> x + y); // 0 + v1 + v2 + ...
    System.out.println(sum2);
  }
}

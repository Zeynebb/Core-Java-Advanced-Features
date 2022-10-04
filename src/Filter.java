import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Filter {

  private final List<String> words;
  private final List<String> shortList;

  public Filter(List<String> words) {
    this.words = words;
    shortList = List.of(words.get(0), words.get(1));
  }
  // 1.3 The filter, map, and flatMap Methods
  // 1.5. Other Stream Transformations
  public void run() {
    // Sadece koşulu sağlayan değerleri stream'e ekler.
    Utils.addHeader("filter");
    words.stream().filter(w -> w.length() > 4).forEach(System.out::println);

    // Stream içerisindeki değerleri koşula uygun hale getirir.
    Utils.addHeader("map");
    words.stream().map(String::toLowerCase).forEach(System.out::println);
    words.stream().map(s -> s.substring(0, 1)).forEach(System.out::println);

    // İç içe stream'leri tek bir stream haline getirir.
    Utils.addHeader("flatMap");
    Stream<Stream<String>> result = shortList.stream().map(w -> codePoints(w));
    // [["H", "e", "l", "l", "o"], ["W", "o", "r", "l", "d"]].
    // result.forEach(stringStream -> stringStream.forEach(s -> System.out.println(s)));
    Stream<String> flatResult = shortList.stream().flatMap(w -> codePoints(w));
    // ["H", "e", "l", "l", "o", "W", "o", "r", "l", "d"]
    flatResult.forEach(System.out::println);

    // Koşulu sağlayan değerler arasından belirtilen sayıdan önceki değerleri stream'e ekler.
    Utils.addHeader("limit");
    shortList.stream().flatMap(w -> codePoints(w)).limit(5).forEach(System.out::println);

    // Koşulu sağlayan değerler arasından belirtilen sayıdan sonraki değerleri stream'e ekler.
    Utils.addHeader("skip");
    shortList.stream().flatMap(w -> codePoints(w)).skip(5).forEach(System.out::println);

    // Sadece koşulu sağlayan değerleri stream'e ekler.
    Utils.addHeader("takeWhile");
    codePoints("whr").takeWhile(s -> "hellow".contains(s)).forEach(System.out::println);

    // Koşulu sağlayan değerler dışındaki tüm değerleri stream'e ekler.
    Utils.addHeader("dropWhile");
    codePoints("whr").dropWhile(s -> "hellow".contains(s)).forEach(System.out::println);

    // İki stream'i birleştirir.
    Utils.addHeader("concat");
    Stream.concat(
            words.stream().filter(w -> w.length() > 6),
            shortList.stream().flatMap(Filter::codePoints).limit(5))
        .forEach(System.out::println);

    // Stream'de aynı değerden birden fazla bulunuyorsa yalnızca birini alır.
    Utils.addHeader("distinct");
    words.stream().distinct().forEach(System.out::println);

    // Belirtilen koşula göre sıralama yapar.
    Utils.addHeader("sorted");
    words.stream()
        .sorted(Comparator.comparing(String::length).reversed())
        .forEach(System.out::println);

    // peek metodu içerisindeki işlem stream'deki her değerden sonra uygulanır.
    Utils.addHeader("peek");
    Stream.iterate(1, p -> p * 2)
        .peek(
            s -> {
              if (s > 4) System.out.println(s);
            })
        .limit(8)
        .toList();
  }

  public static Stream<String> codePoints(String s) {
    return s.codePoints().mapToObj(cp -> new String(new int[] {cp}, 0, 1));
  }
}

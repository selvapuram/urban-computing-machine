import java.util.*;
public class GetLargestNumberInArray {

    public static void main(String[] args) {
        System.out.println("Hello World");
        List<String> arr = new ArrayList<>();
        arr.add("1");
        arr.add("34");
        arr.add("3");
        arr.add("98");
        arr.add("9");
        arr.add("76");
        arr.add("45");
        arr.add("4");
        arr.sort((X, Y) -> {
            String XY = X + Y;
            String YX = Y + X;
            return XY.compareTo(YX) > 0 ? -1 : 1;
        });
        System.out.println(arr.toString());
    }
}
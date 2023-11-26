import java.util.ArrayList;
import java.util.List;

/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        List<Object> lis = new ArrayList<>();
        lis.add("Vasya");
        lis.add("Lork");
        lis.add("Sveta");
        System.out.println(lis);
        for (int i = 0; i < lis.size(); i++) {
            lis.remove(i);
            System.out.println(lis);
        }
        System.out.println(lis);
    }
}
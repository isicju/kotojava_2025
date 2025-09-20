import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello Java Enterprise course 2025!");

        System.out.println("=== Apache Commons Lang3 Demo ===");

        String text = "hello world";
        System.out.println("Original: " + text);
        System.out.println("Capitalized: " + StringUtils.capitalize(text));
        System.out.println("Reversed: " + StringUtils.reverse(text));
        System.out.println("Contains 'world': " + StringUtils.contains(text, "world"));

        System.out.println("\n=== System Information ===");
        System.out.println("Java Home: " + SystemUtils.getJavaHome());
        System.out.println("User Home: " + SystemUtils.getUserHome());
        System.out.println("OS Name: " + SystemUtils.OS_NAME);
        System.out.println("OS Version: " + SystemUtils.OS_VERSION);

        System.out.println("\n=== Array Demo ===");
        String[] fruits = {"apple", "banana", "cherry"};
        System.out.println("Array: " + java.util.Arrays.toString(fruits));
        System.out.println("Contains 'banana': " +
                org.apache.commons.lang3.ArrayUtils.contains(fruits, "banana"));
    }
}

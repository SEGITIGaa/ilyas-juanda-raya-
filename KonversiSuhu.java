import java.util.Scanner;

public class KonversiSuhu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan suhu dalam Celsius: ");
        double celsius = scanner.nextDouble();

        double kelvin = celsiusToKelvin(celsius);
        double fahrenheit = celsiusToFahrenheit(celsius);

        System.out.println("Suhu dalam Kelvin: " + kelvin + " K");
        System.out.println("Suhu dalam Fahrenheit: " + fahrenheit + " °F");

        scanner.close();
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}

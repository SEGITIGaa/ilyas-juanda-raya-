import java.util.Scanner;

public class Kalkulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculating = true;

        System.out.println("======================================");
        System.out.println("SELAMAT DATANG DI KALKULATOR SEDERHANA");
        System.out.println("======================================");
        do {
            System.out.print("Masukkan angka pertama: ");
            double num1 = scanner.nextDouble();

            System.out.print("Masukkan angka kedua: ");
            double num2 = scanner.nextDouble();

            System.out.println("======================================");

            System.out.println("Pilih operasi: ");
            System.out.println("1. Penambahan (+)");
            System.out.println("2. Pengurangan (-)");
            System.out.println("3. Perkalian (*)");
            System.out.println("4. Pembagian (/)");
            int operationChoice = scanner.nextInt();

            double result = 0;

            switch (operationChoice) {
                case 1:
                    result = num1 + num2;
                    break;
                case 2:
                    result = num1 - num2;
                    break;
                case 3:
                    result = num1 * num2;
                    break;
                case 4:
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Tidak bisa melakukan pembagian dengan angka 0.");
                        continue;
                    }
                    break;
                default:
                    System.out.println("Operasi tidak valid.");
                    continue;
            }

            System.out.println("======================================");

            System.out.println("Hasil operasi: " + result);

            System.out.print("Apakah Anda ingin melakukan operasi lain? (y/t): ");
            String continueChoice = scanner.next().toLowerCase();
            if (!continueChoice.equals("y")) {
                continueCalculating = false;
                System.out.println("makasi udah pake kalkulator nyaa!, pinjem dulu seratus");
            };
        } while (continueCalculating);

        scanner.close();
    }
}

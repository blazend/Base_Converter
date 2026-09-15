import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input your base: ");
        int base = scanner.nextInt();

        System.out.print("Input your number: ");
        String inputNumber = scanner.next().toUpperCase();
        int decimal = baseToDec(inputNumber, base);

        System.out.print("\n");

        System.out.println("Decimal: " + decimal);
        System.out.println("Binary: " + decToBase(decimal, 2));
        System.out.println("Octal: " + decToBase(decimal, 8));
        System.out.println("Hexadecimal: " + decToBase(decimal, 16));


//        int base = 16;
//        String num = "FF";
//        int decimal = baseToDec(num, base);



    }

    private static int baseToDec(String original, int base) {



        String binary = new StringBuilder(original).reverse().toString();
        int decimal = 0;

        for (int i = 0; i < binary.length(); i++) {
            char c = binary.charAt(i);

            int num = Character.getNumericValue(c);
            //System.out.println(num);

            decimal = (int) (decimal + (num * Math.pow(base, i)));
        }
        return decimal;

    }


    private static String decToBase(int num, int base) {

        String digits = "0123456789ABCDEF";
        String convertedNum = "";

        while (num > 0) {

            if (num == 0) {
                break;
            }

            int remainder = num % base;
            convertedNum = digits.charAt(remainder) + convertedNum;
            num = num / base;
        }

        return convertedNum;
    }

}
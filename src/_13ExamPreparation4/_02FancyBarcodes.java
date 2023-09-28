package _13ExamPreparation4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String barcodeRegex = "(?<prefix>@#+)(?<barcode>[A-Z][A-Za-z0-9]{4,}[A-Z])(?<suffix>@#+)";
        Pattern pattern = Pattern.compile(barcodeRegex);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();

            Matcher matcher = pattern.matcher(input);

            if(matcher.matches()) {
                String barcode = matcher.group("barcode");

                String productGroup = "";
                boolean hasDigit = false;

                for (char c : barcode.toCharArray()) {
                    if(Character.isDigit(c)) {
                        productGroup += c;
                        hasDigit = true;
                    }
                }

                if(!hasDigit) {
                    productGroup = "00";
                }

                System.out.println("Product group: " + productGroup);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}

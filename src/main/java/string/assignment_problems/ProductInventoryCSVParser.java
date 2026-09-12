package string.assignment_problems;

public class ProductInventoryCSVParser {

    static void parseInventoryRecord(
            String csvLine) {

        String[] fields =
                csvLine.split(",");

        if (fields.length != 3) {

            System.out.println(
                    "Invalid Record"
            );

            return;
        }

        String product = fields[0];
        String sku = fields[1];
        String quantity = fields[2];

        System.out.println(
                "Product: " + product +
                " | SKU: " + sku +
                " | Qty: " + quantity
        );
    }

    public static void main(String[] args) {

        String record =
                "Wireless Mouse,WM-2201,150";

        parseInventoryRecord(record);
    }
}
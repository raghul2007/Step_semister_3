package string.assignment_problems;

public class Cart {

    private final String cartId;
    private final double[] prices;
    private int itemCount;

    public Cart(
            String cartId,
            int maxItems) {

        this.cartId = cartId;
        this.prices = new double[maxItems];
        this.itemCount = 0;
    }

    public void addItem(double price) {

        if (price > 0 &&
                itemCount < prices.length) {

            prices[itemCount] = price;
            itemCount++;

        } else {

            System.out.println(
                    "Item cannot be added"
            );
        }
    }

    public double getTotal() {

        double total = 0;

        for (int i = 0;
             i < itemCount;
             i++) {

            total += prices[i];
        }

        return total;
    }

    public int getItemCount() {

        return itemCount;
    }

    public String getCartId() {

        return cartId;
    }

    public static void main(String[] args) {

        Cart cart =
                new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println(
                "Total: " +
                cart.getTotal()
        );

        System.out.println(
                "Item Count: " +
                cart.getItemCount()
        );
    }
}
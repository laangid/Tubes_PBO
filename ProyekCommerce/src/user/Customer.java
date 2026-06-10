// Disusun oleh:
// Daniel Lamganda Tua G.	(24060124120048)
// Dehar Zaidan Dzaki A.	(24060124130099)
// Dzaki Fathul'Alim Cahyo	(24060124130103)
// Elang Fadila Ahmad	    (24060124130108)
package user;
import java.text.NumberFormat;
import java.util.Locale;
import order.*;
import payment.*;
import product.*;
import repository.*;

public class Customer extends User {
    private Cart cart;

    public Customer(String email, String id, String name, String password) {
        super(email, id, name, password);
        this.cart = new Cart();
    }

    // Getter
    public Cart getCart() {
        return cart;
    }

    // Setter
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void addToCart(Product p, int qty) {
        cart.addItem(p, qty);
    }

    public void addToCart(Product p) {
        cart.addItem(p, 1);
    }

    public void checkout(ProductRepository repo, Payment payment) {
        boolean success = payment.processPayment();

        if (!success) {
            throw new IllegalStateException("Pembayaran gagal");
        }

        Order order = new Order(this);
        double total = order.calculateTotal();

        NumberFormat nf =
            NumberFormat.getInstance(new Locale("id", "ID"));

        System.out.println("Checkout berhasil");
        System.out.println("Order ID: " + order.getId());
        System.out.println("Total: Rp" + nf.format(total));

        // KURANGI STOK
        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();
            int qty = item.getQuantity();

            try {
                p.updateStock(qty);
                repo.update(p);
            } catch (Exception e) {
                System.out.println("Stock error: " + e.getMessage());
            }
        }

        cart.getItems().clear();
    }
}
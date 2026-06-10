// Disusun oleh:
// Daniel Lamganda Tua G.	(24060124120048)
// Dehar Zaidan Dzaki A.	(24060124130099)
// Dzaki Fathul'Alim Cahyo	(24060124130103)
// Elang Fadila Ahmad	    (24060124130108)
package order;

import java.util.ArrayList;
import java.util.List;
import product.*;

public class Cart {
    private String id;
    private List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public Cart(String id) {
        this.id = id;
        this.items = new ArrayList<>();
    }

    // Getter
    public String getId() {
        return id;
    }

    public List<CartItem> getItems() {
        return items;
    }

    // Setter
    public void setId(String id) {
        this.id = id;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public void addItem(Product p, int qty) {
        assert p != null : "Product tidak boleh null";

        if (qty <= 0) {
            throw new IllegalArgumentException("Quantity harus > 0");
        }

        for (CartItem item : items) {
            if (item.getProduct().equals(p)) {
                item.setQuantity(item.getQuantity() + qty);
                return;
            }
        }
        items.add(new CartItem(p, qty));
    }

    public double getTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }
}

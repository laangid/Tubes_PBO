// Disusun oleh:
// Daniel Lamganda Tua G.	(24060124120048)
// Dehar Zaidan Dzaki A.	(24060124130099)
// Dzaki Fathul’Alim Cahyo	(24060124130103)
// Elang Fadila Ahmad	    (24060124130108)

package payment;
public abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount harus lebih dari 0");
        }
        this.amount = amount;
    }

    // Getter
    public double getAmount() {
        return amount;
    }

    // Setter
    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Method abstract
    public abstract boolean processPayment();
}
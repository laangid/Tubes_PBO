// Disusun oleh:
// Daniel Lamganda Tua G.	(24060124120048)
// Dehar Zaidan Dzaki A.	(24060124130099)
// Dzaki Fathul’Alim Cahyo	(24060124130103)
// Elang Fadila Ahmad	    (24060124130108)

package payment;
public class CreditCard extends Payment {
    private String cardNumber;

    public CreditCard(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    // Getter
    public String getCardNumber() {
        return cardNumber;
    }

    // Setter
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean processPayment() {
        assert amount > 0 : "Amount tidak valid";

        if (cardNumber == null || cardNumber.length() < 8) {
            throw new IllegalStateException("Nomor kartu tidak valid");
        }

        System.out.println("Processing Credit Card payment...");
        return true;
    }
}
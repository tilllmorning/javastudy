package Attestation01;

import java.time.LocalDate;

public class DiscountProduct extends Product {
    private int discount; // в процентах (например, 20 = 20%)
    private LocalDate expiryDate;

    public DiscountProduct(String name, int price, int discount, LocalDate expiryDate) {
        super(name, price);
        if (discount <= 0 || discount >= 100) {
            throw new IllegalArgumentException("Скидка должна быть в пределах от 1 до 99%");
        }
        if (expiryDate == null) {
            throw new IllegalArgumentException("Дата окончания скидки должна быть задана");
        }
        this.discount = discount;
        this.expiryDate = expiryDate;
    }

    @Override
    public int getPrice() {
        LocalDate today = LocalDate.now();
        if (today.isBefore(expiryDate) || today.isEqual(expiryDate)) {
            int discountedPrice = super.getPrice() * (100 - discount) / 100;
            return discountedPrice > 0 ? discountedPrice : 1;
        } else {
            return super.getPrice();
        }
    }

    @Override
    public String toString() {
        return super.getName() + " (со скидкой " + discount + "%, до " + expiryDate + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (!(o instanceof DiscountProduct)) return false;
        DiscountProduct dp = (DiscountProduct) o;
        return discount == dp.discount && expiryDate.equals(dp.expiryDate);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + discount + expiryDate.hashCode();
    }
}

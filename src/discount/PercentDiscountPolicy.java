package discount;

public class PercentDiscountPolicy implements DiscountPolicy{
    private final double discountPercent;

    public PercentDiscountPolicy(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public int applyPolicy(int price) {
        return (int) (price * (100 - discountPercent));
    }
}

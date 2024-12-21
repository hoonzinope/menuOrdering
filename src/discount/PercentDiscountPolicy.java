package discount;

public class PercentDiscountPolicy implements DiscountPolicy{
    private final double discountPercent;

    public PercentDiscountPolicy(double discountPercent) throws IllegalArgumentException{
        if(discountPercent < 0 || discountPercent > 100)
            throw new IllegalArgumentException("discount percent 0 to 100");
        this.discountPercent = discountPercent;
    }

    @Override
    public int applyPolicy(int price) {
        return (int) (price * (1 - discountPercent / 100));
    }
}

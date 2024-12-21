package discount;

public class NoDiscountPolicy implements DiscountPolicy{
    @Override
    public int applyPolicy(int price) {
        return price;
    }
}

package discount;

public class FixedPriceDiscountPolicy implements DiscountPolicy{

    private final int fixedDiscountPrice;

    public FixedPriceDiscountPolicy(int discountPrice){
        fixedDiscountPrice = discountPrice;
    }

    @Override
    public int applyPolicy(int price) {
        int finalPrice = price - fixedDiscountPrice;
        return Math.max(finalPrice, 0);
    }
}

package org.chapter2;

/**
 * 고정 금액 할인 정책
 */
public class AmountDiscountPolicy extends DiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }


    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}

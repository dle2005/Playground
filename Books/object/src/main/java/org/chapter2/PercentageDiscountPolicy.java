package org.chapter2;

/**
 * 할인 비율 할인 정책
 */
public class PercentageDiscountPolicy extends DiscountPolicy {
    private double percent;

    public PercentageDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}

package org.chapter2;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

/**
 * 영화
 */
public class Movie {
    private String title;                   // 제목
    private Duration runningTime;           // 상영시간
    private Money fee;                      // 기본 요금
    private DiscountPolicy discountPolicy;  // 할인 정책

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    Movie avatar = new Movie("아바타",
            Duration.ofMinutes(120),
            Money.wons(10000),
            new AmountDiscountPolicy(Money.wons(800),
                    new SequenceCondition(1),
                    new SequenceCondition(10),
                    new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                    new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))
            )
    );

    Movie titanic = new Movie("타이타닉",
            Duration.ofMinutes(180),
            Money.wons(11000),
            new PercentageDiscountPolicy(0.1,
                    new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                    new SequenceCondition(2),
                    new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))
            )
    );
}

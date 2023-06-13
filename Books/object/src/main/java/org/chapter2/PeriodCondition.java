package org.chapter2;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * 기간 조건
 * 상영 시작 시간이 특정한 기간 안에 포함되는지 여부를 판단해 할인 여부를 결정
 */
public class PeriodCondition implements DiscountCondition {
    private DayOfWeek dayOfWeek;    // 요일
    private LocalTime startTime;    // 시작 시간
    private LocalTime endTime;      /// 종료 시간

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // 상영 요일이 같고, 상영 시작 시간이 start ~ endTime 경우 ture
    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
                startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0 &&
                endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;
    }
}

package org.chapter2;

import java.time.LocalDateTime;

/**
 * 상영
 */
public class Screening {
    private Movie movie;                    // 상영할 영화
    private int sequence;                   // 순번
    private LocalDateTime whenScreened;     // 상영 시작 시간

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    // 상영 시작 시간을 반환
    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    // 순번의 일치 여부를 검사
    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    // 기본 요금을 반환
    public Money getMovieFee() {
        return movie.getFee();
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}

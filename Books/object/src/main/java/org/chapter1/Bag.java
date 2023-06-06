package org.chapter1;

/**
 * 가방
 *
 * 이벤트 당첨자는 티켓으로 교환할 초대장을 가지고 있을 것이다.
 * 이벤트에 당첨되지 않은 관람객은 티켓을 구매할 수 있는 현금을 보유하고 있을 것이다.
 */
public class Bag {
    private Long amount;
    private Invitation invitation;      // 초대장
    private Ticket ticket;              // 티켓

    // 초대장 보유여부를 판단
    public boolean hasInvitation() {
        return invitation != null;
    }

    // 티켓의 소유 여부를 판단
    public boolean hasTicket() {
        return ticket != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }

    // 초대장 없이 현금만 보관하는 경우
    public Bag(long amount) {
        this(null, amount);
    }

    // 현금과 초대장을 함께 보관하는 경우
    public Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public Long hold(Ticket ticket) {
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else {
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }
}

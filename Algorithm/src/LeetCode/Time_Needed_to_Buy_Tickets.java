package LeetCode;

public class Time_Needed_to_Buy_Tickets {
    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[]{2, 3, 2}, 2));
        System.out.println(timeRequiredToBuy(new int[]{5, 1, 1, 1}, 0));
        System.out.println(timeRequiredToBuy(new int[]{84, 49, 5, 24, 70, 77, 87, 8}, 3));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int output = 0;

        for (int idx = 0; idx < tickets.length; idx++) {
            output += Math.min(tickets[idx], idx <= k ? tickets[k] : tickets[k] - 1);
        }

        return output;
    }
}

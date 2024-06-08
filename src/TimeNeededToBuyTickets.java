public class TimeNeededToBuyTickets {

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int count = 0;
        for (int i = 0; i < tickets.length; i++) {
            count+= Math.min(tickets[i], tickets[k]);
            if (i > k && tickets[i] >= tickets[k]) {
                count--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(timeRequiredToBuy(new int[]{84,49,5,24,70,77,87,8}, 3));
    }
}

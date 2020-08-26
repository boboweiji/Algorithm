import java.util.*;
class Ticket implements Comparable<Ticket> {
    public int value;
    public int seq;

    public Ticket(int value, int seq) {
        this.value = value;
        this.seq = seq;
    }

    @Override
    public int compareTo(Ticket o) {
        if(this.seq>o.seq){
            return 1;
        } else if(this.seq<o.seq){
            return -1;
        } else {
            return 0;
        }
    }
}
public class 小猿的抽奖 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int dp[] = new int[N];
        int result = Integer.MIN_VALUE;
        Ticket[] tickets = new Ticket[N];
        for(int i=0;i<N;i++){
            int value = in.nextInt();
            int seq = in.nextInt();
            tickets[i] = new Ticket(value,seq);
        }
        Arrays.sort(tickets);
        dp[0] = tickets[0].value;
        if(dp[0]>result) result = dp[0];
        for(int i=1;i<N;i++){
            int seq = tickets[i].seq-2;
            dp[i] = Math.max(tickets[i].value,dp[seq]+tickets[i].value);
            if(dp[i]>result) result = dp[i];
        }
        System.out.println(result);
    }
}

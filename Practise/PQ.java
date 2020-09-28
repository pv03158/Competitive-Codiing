import java.util.PriorityQueue;
import java.util.Collections;

public class PQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(23);
        pq.add(5);
        pq.add(60);
        pq.add(10);

        pq.remove(60);
        while(pq.size() != 0) {
            System.out.println(pq.remove());
        }
    }
}
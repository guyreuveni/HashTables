import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class projectTwoPlayground {
    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();
        int m = 10000019;
        long QPsteps = 0;
        long AQPsteps = 0;
        int n = (int) Math.floor(m / 2);
        int prevQPstep = 0;
        int prevAQPstep = 0;
        int currQPstep = 0;
        int currAQPstep = 0;
        for (int i = 0; i < n; i++) {
            currQPstep = (int) (((long) i * (long) i) % m);
            s.add(currQPstep);
            if (i % 2 == 0) {
                currAQPstep = (int) (((long) i * (long) i) % m);
            } else {
                currAQPstep = (int) ((((((-1) * (long) i * (long) i)) % m) + (long) m)
                        % m);
            }
            QPsteps += Math.abs(prevQPstep - currQPstep);
            AQPsteps += Math.abs(prevAQPstep - currAQPstep);
            prevQPstep = currQPstep;
            prevAQPstep = currAQPstep;
        }

        double avgQPstep = ((double) QPsteps) / ((double) n);
        double avgAQPstep = ((double) AQPsteps) / ((double) n);

        System.out.println("avg step length in qp is : " + avgQPstep);
        System.out.println("avg step length in Aqp is : " + avgAQPstep);
        System.out.println("size of set is " + s.size());
    }
}
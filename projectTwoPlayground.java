import java.util.concurrent.ThreadLocalRandom;

public class projectTwoPlayground {
    public static void main(String[] args) {
        int m = 10000019;
        long p = 1000000007;
        double startTime = 0;
        double endTime = 0;
        double regTime = 0, altTime = 0;
        int sign;
        long randNum;
        int res;
        for (int i = 0; i < m; i++) {
            randNum = ThreadLocalRandom.current().nextLong(0, m);
            // regTime
            startTime = System.nanoTime();
            res = (int) ((randNum + 1L * (long) Math.pow(i, 2))) % m;
            endTime = System.nanoTime();
            regTime += endTime - startTime;

            // altTime
            sign = (int) Math.pow(-1, i);
            sign = (int) Math.pow(-1, i % 2);
            startTime = System.nanoTime();
            if (i % 2 == 0) {
                sign = 1;
            } else {
                sign = -1;
            }
            res = (int) ((randNum + sign * (long) Math.pow(i, 2))) % m;
            endTime = System.nanoTime();
            altTime += endTime - startTime;
        }
        System.out.println("Total runtime positive modulos " + Math.pow(10, -9) * regTime);
        System.out.println("Total runtime alternating signs modulos " + Math.pow(10, -9) * altTime);
    }

}

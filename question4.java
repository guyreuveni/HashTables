import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class question4 {

    private static int m = 10000019;
    private static long p = 1000000007;

    public static void main(String[] args) throws Exception {
        System.out.println("### question 4a ####");
        question4.partA(10);
        // System.out.println("### question 4b ####");
        // question4.partB(10);
    }

    private static void partA(int times) throws Exception {
        int n = (int) Math.floor(m / 2);
        question4.makeExperiment(times, n, 'A');
    }

    private static void partB(int times) throws Exception {
        int n = (int) Math.floor((m * 19) / 20);
        question4.makeExperiment(times, n, 'B');
    }

    private static void makeExperiment(int times, int n, char ch) throws Exception {
        double LPTime = 0;
        double QPTime = 0;
        double AQPTime = 0;
        double DHTime = 0;
        // double LPComputingTime = 0;
        // double QPComputingTime = 0;
        // double AQPComputingTime = 0;
        // double DHComputingTime = 0;
        double LPsteps = 0;
        double QPsteps = 0;
        double AQPsteps = 0;
        double DHsteps = 0;
        for (int i = 0; i < times; i++) {
            LPHashTable LPtable = new LPHashTable(m, p);
            QPHashTable QPtable = new QPHashTable(m, p);
            AQPHashTable AQPtable = new AQPHashTable(m, p);
            DoubleHashTable DHtable = new DoubleHashTable(m, p);
            List<HashTableElement> randSeq = question4.getRandomSeq(n);
            if (ch == 'A') {
                QPTime += question4.measureTime(randSeq, QPtable);
            }
            AQPTime += question4.measureTime(randSeq, AQPtable);
            DHTime += question4.measureTime(randSeq, DHtable);
            LPTime += question4.measureTime(randSeq, LPtable);

            // if (ch == 'A') {
            // QPComputingTime += QPtable.computingTime;
            // }
            // LPComputingTime += LPtable.getAvgComputingCost();
            // AQPComputingTime += AQPtable.getAvgComputingCost();
            // DHComputingTime += DHtable.getAvgComputingCost();

            if (ch == 'A') {
                QPsteps += QPtable.getAvgStepLength();
            }
            LPsteps += LPtable.getAvgStepLength();
            AQPsteps += AQPtable.getAvgStepLength();
            DHsteps += DHtable.getAvgStepLength();

        }
        System.out.println("LPHashTable avg runtime over " + times + " experiments in seconds: "
                + (LPTime / times) / Math.pow(10, 9));

        if (ch == 'A') {
            System.out.println("QPHashTable avg runtime over " + times + " experiments in seconds: "
                    + (QPTime / times) / Math.pow(10, 9));
        }
        System.out.println("AQPHashTable avg runtime over " + times + " experiments in seconds: "
                + (AQPTime / times) / Math.pow(10, 9));

        System.out.println("DoubleHashTable avg runtime over " + times + " experiments in seconds: "
                + (DHTime / times) / Math.pow(10, 9));

        // steps///

        System.out.println("LPHashTable avg steplength over " + times + " experiments is: "
                + (LPsteps / (double) times));

        if (ch == 'A') {
            System.out.println("QPHashTable avg steplength over " + times + " experiments is: "
                    + (QPsteps / (double) times));
        }
        System.out.println("AQPHashTable avg steplength over " + times + " experiments is: "
                + (AQPsteps / (double) times));

        System.out.println("DoubleHashTable avg steplength over " + times + " experiments is: "
                + (DHsteps / (double) times));
    }
3ת
    // System.out.println("LPHashTable avg computing time over " + times + "
    // experiments in seconds: "
    // + (LPComputingTime / times) / Math.pow(10, 9));
    // if (ch == 'A') {
    // System.out.println("QPHashTable avg computing time over " + times + "
    // experiments in seconds: "
    // + (QPComputingTime / times) / Math.pow(10, 9));
    // }
    // System.out.println("AQPHashTable avg computing time over " + times + "
    // experiments in seconds: "
    // + (AQPComputingTime / times) / Math.pow(10, 9));

    // System.out.println("DoubleHashTable avg computing time over " + times + "
    // experiments in seconds: "
    // + (DHComputingTime / times) / Math.pow(10, 9));
    // }

    private static double measureTime(List<HashTableElement> randSeq, IHashTable table) throws Exception {
        double startTime = System.nanoTime();
        for (HashTableElement elem : randSeq) {
            table.Insert(elem);
        }
        double endTime = System.nanoTime();
        double time = endTime - startTime;
        return time;
    }

    private static List<HashTableElement> getRandomSeq(int n) {
        List<HashTableElement> randSeq = new ArrayList<>();
        long Bi;
        Long Ai;
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            Bi = random.nextInt(100);
            Ai = 100 * i + Bi;
            HashTableElement hte = new HashTableElement(Ai, 0);
            randSeq.add(hte);
        }
        return randSeq;
    }
}

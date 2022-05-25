import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class expiriments {

    public static void main(String[] args) throws Exception {
        // expiriments.q1QP();
        expiriments.q1AQP();
        System.out.println("###question 4a ####");
        expiriments.q2s1();
        System.out.println("###question 4b ####");
        expiriments.q2s2();
        expiriments.q3();
    }

    private static void q1AQP() throws Exception {
        Random rand = new Random();
        for (int j = 0; j < 100; j++) {
            AQPHashTable AQPtable = new AQPHashTable(6571, 1000000007);
            for (int i = 0; i < 6571; i++) {
                long b = rand.nextInt(100);
                long a = 100 * i + b;
                HashTableElement hte = new HashTableElement(a, 0);
                AQPtable.Insert(hte);
            }
        }
    }

    private static void q1QP() throws Exception {
        for (int j = 0; j < 100; j++) {
            QPHashTable QPtable = new QPHashTable(6571, 1000000007);
            for (int i = 0; i < 6571; i++) {
                long b = ThreadLocalRandom.current().nextLong(100);
                long a = 100 * i + b;
                HashTableElement hte = new HashTableElement(a, 0);
                QPtable.Insert(hte);
            }
        }
    }

    private static void q2s1LP() throws Exception {
        LPHashTable table = new LPHashTable(10000019, 1000000007);
        int n = 10000019 / 2;
        for (int i = 0; i < n; i++) {
            long b = ThreadLocalRandom.current().nextLong(100);
            long a = 100 * i + b;
            HashTableElement hte = new HashTableElement(a, 0);
            table.Insert(hte);
        }
        // System.out.println("cach misses for LP " + table.chachmiss);
        // System.out.println("Avg step length for LP " + table.getAvgStepLength());
    }

    private static void q2s1QP() throws Exception {
        QPHashTable table = new QPHashTable(10000019, 1000000007);
        int n = 10000019 / 2;
        for (int i = 0; i < n; i++) {
            long b = ThreadLocalRandom.current().nextLong(100);
            long a = 100 * i + b;
            HashTableElement hte = new HashTableElement(a, 0);
            table.Insert(hte);
        }
        // System.out.println("cach misses for QP " + table.chachmiss);
        // System.out.println("Avg step length for QP " + table.getAvgStepLength());

    }

    private static void q2s1AQP() throws Exception {
        AQPHashTable table = new AQPHashTable(10000019, 1000000007);
        int n = 10000019 / 2;
        for (int i = 0; i < n; i++) {
            long b = ThreadLocalRandom.current().nextLong(100);
            long a = 100 * i + b;
            HashTableElement hte = new HashTableElement(a, 0);
            table.Insert(hte);
        }
        // System.out.println("cach misses for AQP " + table.chachmiss);
        // System.out.println("Avg step length for AQP " + table.getAvgStepLength());
    }

    private static void q2s1Double() throws Exception {
        DoubleHashTable table = new DoubleHashTable(10000019, 1000000007);
        int n = 10000019 / 2;
        for (int i = 0; i < n; i++) {
            long b = ThreadLocalRandom.current().nextLong(100);
            long a = 100 * i + b;
            HashTableElement hte = new HashTableElement(a, 0);
            table.Insert(hte);
        }
        // System.out.println("cach misses for Double " + table.chachmiss);
        // System.out.println("Avg step length for Double " + table.getAvgStepLength());

    }

    private static void q2s1() throws Exception {
        Instant inst1 = Instant.now();
        expiriments.q2s1LP();
        Instant inst2 = Instant.now();
        System.out.println("run time for LP " + Duration.between(inst1, inst2).toString());

        inst1 = Instant.now();
        expiriments.q2s1QP();
        inst2 = Instant.now();
        System.out.println("run time for QP " + Duration.between(inst1, inst2).toString());

        inst1 = Instant.now();
        expiriments.q2s1AQP();
        inst2 = Instant.now();
        System.out.println("run time for AQP " + Duration.between(inst1, inst2).toString());

        inst1 = Instant.now();
        expiriments.q2s1Double();
        inst2 = Instant.now();
        System.out.println("run time for Double " + Duration.between(inst1, inst2).toString());
    }

    private static void q2s2LP() throws Exception {
        LPHashTable table = new LPHashTable(10000019, 1000000007);
        int n = (int) Math.floor((19 * 10000019) / 20);
        for (int i = 0; i < n; i++) {
            long b = ThreadLocalRandom.current().nextLong(100);
            long a = 100 * i + b;
            HashTableElement hte = new HashTableElement(a, 0);
            table.Insert(hte);
        }
    }

    private static void q2s2AQP() throws Exception {
        AQPHashTable table = new AQPHashTable(10000019, 1000000007);
        int n = (int) Math.floor((19 * 10000019) / 20);
        for (int i = 0; i < n; i++) {
            long b = ThreadLocalRandom.current().nextLong(100);
            long a = 100 * i + b;
            HashTableElement hte = new HashTableElement(a, 0);
            table.Insert(hte);
        }
    }

    private static void q2s2Double() throws Exception {
        DoubleHashTable table = new DoubleHashTable(10000019, 1000000007);
        int n = (int) Math.floor((19 * 10000019) / 20);
        for (int i = 0; i < n; i++) {
            long b = ThreadLocalRandom.current().nextLong(100);
            long a = 100 * i + b;
            HashTableElement hte = new HashTableElement(a, 0);
            table.Insert(hte);
        }
    }

    private static void q2s2() throws Exception {
        Instant inst1 = Instant.now();
        expiriments.q2s2LP();
        Instant inst2 = Instant.now();
        System.out.println("run time for LP " + Duration.between(inst1, inst2).toString());

        inst1 = Instant.now();
        expiriments.q2s2AQP();
        inst2 = Instant.now();
        System.out.println("run time for AQP " + Duration.between(inst1, inst2).toString());

        inst1 = Instant.now();
        expiriments.q2s2Double();
        inst2 = Instant.now();
        System.out.println("run time for Double " + Duration.between(inst1, inst2).toString());
    }

    private static void q3() throws Exception {
        DoubleHashTable table = new DoubleHashTable(10000019, 1000000007);
        for (int j = 0; j < 6; j++) {
            List<Long> keys = expiriments.createRandomKeys(10000019 / 2);
            Instant inst1 = Instant.now();
            for (long key : keys) {
                HashTableElement hte = new HashTableElement(key, 0);
                table.Insert(hte);
            }
            for (long key : keys) {
                table.Delete(key);
            }
            Instant inst2 = Instant.now();
            System.out.println(
                    "run time for iteration number: " + j + " is: " + Duration.between(inst1, inst2).toString());
            // System.out
            // .println("num of cells deleted after iteration number: " + j + " is: " +
            // OAHashTable.numOfDeleted);
        }
        // expiriments.InsertAndDeleteSeq(table);
        // expiriments.InsertAndDeleteSeq(table);
        // expiriments.InsertAndDeleteSeq(table);
        // Instant inst2 = Instant.now();
        // System.out.println("run time for first 3 iterations " +
        // Duration.between(inst1, inst2).toString());
        // inst1 = Instant.now();
        // expiriments.InsertAndDeleteSeq(table);
        // expiriments.InsertAndDeleteSeq(table);
        // expiriments.InsertAndDeleteSeq(table);
        // inst2 = Instant.now();
        // System.out.println("run time for last 3 iterations " +
        // Duration.between(inst1, inst2).toString());
    }

    private static void InsertAndDeleteSeq(IHashTable table) throws Exception {
        List<Long> keys = new ArrayList<>();
        int n = 10000019 / 2;
        for (int i = 0; i < n; i++) {
            long b = ThreadLocalRandom.current().nextLong(100);
            long a = 100 * i + b;
            HashTableElement hte = new HashTableElement(a, 0);
            keys.add(a);
            table.Insert(hte);
        }

        for (long key : keys) {
            table.Delete(key);
        }
    }

    private static List<Long> createRandomKeys(int length) {
        Random rand = new Random();
        long a;
        long b;
        List<Long> keys = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            b = ThreadLocalRandom.current().nextLong(100);
            a = (100 * i) + b;
            keys.add(a);
        }
        return keys;
    }
}
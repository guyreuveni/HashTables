import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Random;

public class theoretical_part {
    public static void main(String[] args) throws IHashTable.KeyDoesntExistException, IHashTable.KeyAlreadyExistsException, IHashTable.TableIsFullException {
        Set<Long> Q1 = new HashSet<Long>();
        Set<Long> Q2 = new HashSet<Long>();
        long q = 6571;
        for (int i = 0; i < q; i++) {
            Q1.add((long)Math.pow(i, 2) % q);
            Q2.add(((long)Math.pow(-1, i)*(long)Math.pow(i, 2))%q);
        }
        System.out.println("###### Q3a ######");
        System.out.println(String.format("Size of Q1 is: %s",Q1.size()));
        System.out.println(String.format("Size of Q2 is: %s",Q2.size()));

        System.out.println("\n###### Q3b ######");
        System.out.println("## QPHashTable ##");
        Random random = new Random();
        long Ai, Bi;
        try {
            for (int j = 0; j < 100; j++) {
                QPHashTable qpht = new QPHashTable(6571, 1000000007);
                for (int i = 0; i < 6571; i++) {
                    Bi = random.nextInt(100);
                    Ai = 100 * i + Bi;
                    qpht.Insert(new HashTableElement(Ai, 0));
                }
            }
            System.out.println("No Exceptions");
        }
        catch (IHashTable.TableIsFullException e) {
            e.printStackTrace(System.out);
        }
        catch (IHashTable.KeyAlreadyExistsException e) {
            e.printStackTrace(System.out);
        }

        System.out.println("\n## AQPHashTable ##");
        try {
            for (int j = 0; j < 100; j++) {
                AQPHashTable aqpht = new AQPHashTable(6571, 1000000007);
                for (int i = 0; i < 6571; i++) {
                    Bi = random.nextInt(100);
                    Ai = 100 * i + Bi;
                    aqpht.Insert(new HashTableElement(Ai, 0));
                }
            }
            System.out.println("No Exceptions");
        }
        catch (IHashTable.TableIsFullException e) {
            e.printStackTrace(System.out);
        }
        catch (IHashTable.KeyAlreadyExistsException e) {
            e.printStackTrace(System.out);
        }

        System.out.println("\n###### Q4a ######");

        LPHashTable lpht;
        QPHashTable qpht;
        AQPHashTable aqpht;
        DoubleHashTable dht;

        int n = (int) Math.floor(10000019/2);
        double startTime, endTime, lphtTime = 0, qphtTime = 0, aqphtTime = 0, dhtTime = 0;
        for (int j = 0; j < 10; j++) {
            lpht = new LPHashTable(10000019, 1000000007);
            qpht = new QPHashTable(10000019, 1000000007);
            aqpht = new AQPHashTable(10000019, 1000000007);
            dht = new DoubleHashTable(10000019, 1000000007);
            for (int i = 0; i < n; i++) {
                Bi = random.nextInt(100);
                Ai = 100 * i + Bi;

                startTime = System.nanoTime();
                lpht.Insert(new HashTableElement(Ai, 0));
                endTime = System.nanoTime();
                lphtTime += endTime - startTime;

                startTime = System.nanoTime();
                qpht.Insert(new HashTableElement(Ai, 0));
                endTime = System.nanoTime();
                qphtTime += endTime - startTime;

                startTime = System.nanoTime();
                aqpht.Insert(new HashTableElement(Ai, 0));
                endTime = System.nanoTime();
                aqphtTime += endTime - startTime;

                startTime = System.nanoTime();
                dht.Insert(new HashTableElement(Ai, 0));
                endTime = System.nanoTime();
                dhtTime += endTime - startTime;
            }
        }

        System.out.println(String.format("LPHashTable total runtime (avg over 10 experiments) in seconds: %s", (lphtTime/10)/Math.pow(10, 9)));
        System.out.println(String.format("QPHashTable total runtime (avg over 10 experiments) in seconds: %s", (qphtTime/10)/Math.pow(10, 9)));
        System.out.println(String.format("AQPHashTable total runtime (avg over 10 experiments) in seconds: %s", (aqphtTime/10)/Math.pow(10, 9)));
        System.out.println(String.format("DoubleHashTable total runtime (avg over 10 experiments) in seconds: %s", (dhtTime/10)/Math.pow(10, 9)));


        System.out.println("\n###### Q4b ######");

        n = (int) Math.floor((19*10000019)/20);
        lphtTime = 0;
        aqphtTime = 0;
        dhtTime = 0;
        for (int j = 0; j < 10; j++) {
            lpht = new LPHashTable(10000019, 1000000007);
            aqpht = new AQPHashTable(10000019, 1000000007);
            dht = new DoubleHashTable(10000019, 1000000007);
            for (int i = 0; i < n; i++) {
                Bi = random.nextInt(100);
                Ai = 100 * i + Bi;

                startTime = System.nanoTime();
                lpht.Insert(new HashTableElement(Ai, 0));
                endTime = System.nanoTime();
                lphtTime += endTime - startTime;

                startTime = System.nanoTime();
                aqpht.Insert(new HashTableElement(Ai, 0));
                endTime = System.nanoTime();
                aqphtTime += endTime - startTime;

                startTime = System.nanoTime();
                dht.Insert(new HashTableElement(Ai, 0));
                endTime = System.nanoTime();
                dhtTime += endTime - startTime;
            }
        }

        System.out.println(String.format("LPHashTable total runtime (avg over 10 experiments) in seconds: %s", (lphtTime/10)/Math.pow(10, 9)));
        System.out.println(String.format("AQPHashTable total runtime (avg over 10 experiments) in seconds: %s", (aqphtTime/10)/Math.pow(10, 9)));
        System.out.println(String.format("DoubleHashTable total runtime (avg over 10 experiments) in seconds: %s", (dhtTime/10)/Math.pow(10, 9)));

        System.out.println("\n###### Q5 ######");

        n = (int) Math.floor(10000019/2);
        double firstThreeIterTime = 0, lastThreeIterTime = 0;
        for (int k = 0; k < 5; k++) {
            dht = new DoubleHashTable(10000019, 1000000007);
            startTime = System.nanoTime();
            for (int j = 0; j < 6; j++) {
                if (j == 3) {
                    endTime = System.nanoTime();
                    firstThreeIterTime += endTime - startTime;
                    startTime = System.nanoTime();
                }

                // Generating the sequence A, new sequence per iteration
                List<Long> A = new ArrayList<Long>();
                for (int i = 0; i < n; i++) {
                    Bi = random.nextInt(100);
                    Ai = 100 * i + Bi;
                    A.add(Ai);
                    dht.Insert(new HashTableElement(Ai, 0));
                }

                // Deleting every a in A from dht
                for (long a : A) {
                    dht.Delete(a);
                }
            }
            endTime = System.nanoTime();
            lastThreeIterTime += endTime - startTime;
        }

        System.out.println(String.format("First three iterations total runtime (avg over 5 experiments) in seconds: %s", (firstThreeIterTime/5)/Math.pow(10, 9)));
        System.out.println(String.format("Last three iterations total runtime (avg over 5 experiments) in seconds: %s", (lastThreeIterTime/5)/Math.pow(10, 9)));

    }
}

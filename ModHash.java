import java.util.concurrent.ThreadLocalRandom;

public class ModHash {

	private long a;
	private long b;
	private long p;
	private long m;

	public static ModHash GetFunc(int m, long p) {
		long a = ThreadLocalRandom.current().nextLong(1, p);
		long b = ThreadLocalRandom.current().nextLong(p);
		int cnt = 0;
		while (a == b && cnt < 100) {
			b = ThreadLocalRandom.current().nextLong(p);
			cnt++;
		}
		if (a == b) {
			System.out.println("something is wrong with random");
			return null;
		}

		return new ModHash(a, b, p, m);
	}

	private ModHash(long a, long b, long p, long m) {
		this.a = a;
		this.b = b;
		this.p = p;
		this.m = m;
	}

	public int Hash(long key) {
		long val = (((a * key + b) % p) % m);
		return (int) val;
	}
}

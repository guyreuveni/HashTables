import java.util.Random;

public class AQPHashTable extends OAHashTable {

	private ModHash h;

	public AQPHashTable(int m, long p) {
		super(m);
		this.h = ModHash.GetFunc(m, p);
	}

	@Override
	public int Hash(long x, int i) {
		if (i % 2 == 0) {
			return (int) (((long) h.Hash(x) + (long) i * (long) i) % m);
		} else {
			return (int) (((((long) this.h.Hash(x) + ((-1) * (long) i * (long) i)) % m) + (long) m) % m);
		}
	}
}

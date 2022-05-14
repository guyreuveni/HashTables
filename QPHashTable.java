import java.util.Random;

public class QPHashTable extends OAHashTable {

	private ModHash h;

	public QPHashTable(int m, long p) {
		super(m);
		this.h = ModHash.GetFunc(m, p);
	}

	@Override
	public int Hash(long x, int i) {
		// long a = h.Hash(x);
		// long j = i;
		// long val = (a + (j * j)) % m;
		// int index = (int) val;
		// return index;
		return (int) (((long) h.Hash(x) + (long) i * (long) i) % m);
	}
}

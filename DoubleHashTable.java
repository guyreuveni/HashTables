import java.util.Random;

public class DoubleHashTable extends OAHashTable {

	private ModHash h1;
	private ModHash h2;

	public DoubleHashTable(int m, long p) {
		super(m);
		this.h1 = ModHash.GetFunc(m, p);
		this.h2 = ModHash.GetFunc(m - 1, p);
	}

	@Override
	public int Hash(long x, int i) {
		// long a = this.h1.Hash(x);
		// long b = this.h2.Hash(x) + 1;
		// long j = i;
		// long val = (a + (j * b)) % m;
		// int index = (int) val;
		// return index;
		return (int) (((long) this.h1.Hash(x) + ((long) i * (long) (this.h2.Hash(x) + 1))) % m);
	}

}

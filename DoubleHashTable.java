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
		return this.h1.Hash(x) + i * (this.h2.Hash(x) + 1);
	}

}

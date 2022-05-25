import java.util.Random;

public class QPHashTable extends OAHashTable {

	private ModHash h;

	public QPHashTable(int m, long p) {
		super(m);
		this.h = ModHash.GetFunc(m, p);
	}

	@Override
	public int Hash(long x, int i) {
		return (int) (((long) h.Hash(x) + (long) i * (long) i) % m);
	}
}

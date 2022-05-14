import java.util.Random;

public class AQPHashTable extends OAHashTable {

	private ModHash h;

	public AQPHashTable(int m, long p) {
		super(m);
		this.h = ModHash.GetFunc(m, p);
	}

	@Override
	public int Hash(long x, int i) {
		return (int) (((((long) this.h.Hash(x) + (((long) Math.pow(-1, i)) * (long) i * (long) i)) % m) + (long) m)
				% m);
	}
}

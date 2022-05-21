import java.util.Random;

public class AQPHashTable extends OAHashTable {

	private ModHash h;

	public AQPHashTable(int m, long p) {
		super(m);
		this.h = ModHash.GetFunc(m, p);
	}

	@Override
	public int Hash(long x, int i) {
		long sign;
		if (i % 2 == 0) {
			sign = 1;
		} else {
			sign = -1;
		}
		return (int) (((((long) this.h.Hash(x) + ((sign) * (long) i * (long) i)) % m) + (long) m)
				% m);
	}
}

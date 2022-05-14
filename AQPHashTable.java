import java.util.Random;

public class AQPHashTable extends OAHashTable {

	private ModHash h;

	public AQPHashTable(int m, long p) {
		super(m);
		this.h = ModHash.GetFunc(m, p);
	}

	@Override
	public int Hash(long x, int i) {
		return (this.h.Hash(x) + (((int) Math.pow(-1, i)) * i * i)) % m;
	}
}

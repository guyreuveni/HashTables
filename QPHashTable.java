import java.util.Random;

public class QPHashTable extends OAHashTable {

	private ModHash h;

	public QPHashTable(int m, long p) {
		super(m);
		this.h = ModHash.GetFunc(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return (h.Hash(x) + (int) (Math.pow((double) i , 2d))) % m;
	}
}

import java.util.Random;

public class LPHashTable extends OAHashTable {

	private ModHash h;
	
	public LPHashTable(int m, long p) {
		super(m);
		this.h = ModHash.GetFunc(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return (h.Hash(x) + i) % m; 
	}
	
}

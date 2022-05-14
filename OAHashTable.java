
public abstract class OAHashTable implements IHashTable {

	private HashTableElement[] table;
	protected int m;

	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
		this.m = m;
	}

	@Override
	public HashTableElement Find(long key) {
		for (int i = 0; i < m; i++) {
			int probingIndex = this.Hash(key, i);
			HashTableElement elem = this.table[probingIndex];
			if (elem == null) {
				return null;
			}
			if (elem.GetKey() == key) {
				return elem;
			}
		}
		return null;
	}

	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException, KeyAlreadyExistsException {
		if (Find(hte.GetKey()) != null){
			throw new KeyAlreadyExistsException(hte);
		}
		for (int i=0; i < m; i++){
			int probingIndex = this.Hash(hte.GetKey(), i);
			if (this.isCellVirtuallyEmpty(probingIndex)){
				table[probingIndex] = hte;
				return;
			}
		}
		throw new TableIsFullException(hte);
	}

	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		for (int i = 0; i < m; i++) {
			int probingIndex = this.Hash(key, i);
			HashTableElement elem = this.table[probingIndex];
			if (elem == null) {
				throw new KeyDoesntExistException(key);
			}
			if (elem.GetKey() == key) {
				HashTableElement deleted = new HashTableElement(-1, -1);
				this.table[probingIndex] = deleted;
				return;
			}
		}
		throw new KeyDoesntExistException(key);
	}

	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);

	public boolean isCellVirtuallyEmpty(int index) {
		if (this.table[index] == null){
			return true;
		}
		if (this.table[index].GetKey() == -1){
			return true;
		}
		return false;
	}
}

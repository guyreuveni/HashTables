
public abstract class OAtesting implements IHashTable {

    private HashTableElement[] table;
    protected int m;
    private static final HashTableElement DELETED = new HashTableElement(-1, -1);

    public OAtesting(int m) {
        this.table = new HashTableElement[m];
        this.m = m;
    }

    protected double computingTime = 0;
    protected double numOfComputingOpps = 0;
    protected long numOfSteps = 0;
    protected long totalSteps = 0;
    protected int prevProbIndex = 0;
    protected int currProbIndex = 0;

    public double getAvgStepLength() {
        return ((double) totalSteps) / ((double) numOfSteps);
    }

    public double getAvgComputingCost() {
        return computingTime / numOfComputingOpps;
    }

    @Override
    public HashTableElement Find(long key) {
        int probingIndex;
        for (int i = 0; i < m; i++) {
            probingIndex = this.Hash(key, i);
            if (i == 0) {
                this.prevProbIndex = probingIndex;
            } else {
                this.currProbIndex = probingIndex;
                this.totalSteps += Math.abs(this.currProbIndex - this.prevProbIndex);
                this.prevProbIndex = this.currProbIndex;
                this.numOfSteps += 1;
            }
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
        if (Find(hte.GetKey()) != null) {
            throw new KeyAlreadyExistsException(hte);
        }
        int probingIndex;
        for (int i = 0; i < m; i++) {
            probingIndex = this.Hash(hte.GetKey(), i);
            if (i == 0) {
                this.prevProbIndex = probingIndex;
            } else {
                this.currProbIndex = probingIndex;
                this.totalSteps += Math.abs(this.currProbIndex - this.prevProbIndex);
                this.prevProbIndex = this.currProbIndex;
                this.numOfSteps += 1;
            }
            if (this.isCellVirtuallyEmpty(probingIndex)) {
                table[probingIndex] = hte;
                return;
            }
        }
        throw new TableIsFullException(hte);
    }

    @Override
    public void Delete(long key) throws KeyDoesntExistException {
        int probingIndex;
        for (int i = 0; i < m; i++) {
            probingIndex = this.Hash(key, i);
            HashTableElement elem = this.table[probingIndex];
            if (elem == null) {
                throw new KeyDoesntExistException(key);
            }
            if (elem.GetKey() == key) {
                this.table[probingIndex] = DELETED;
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
        if (this.table[index] == null) {
            return true;
        }
        if (this.table[index].GetKey() == -1) {
            return true;
        }
        return false;
    }
}

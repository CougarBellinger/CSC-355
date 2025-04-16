@SuppressWarnings("unchecked")
public class Hashtable<K, V> {
    private Pair<K, V>[] table;
    private int n; // the number of key-value pairs in the table
    private int m; // the size of the table
    private double alphaHigh = 0.5;// resize if n/m exceeds this (1/2)
    private double alphaLow = 0.125;// resize if n/m goes below this (1/8)

    // constructor--default table size is 11
    public Hashtable() {
        n = 0;
        m = 11;
        table = new Pair[m];
    }

    // constructor
    public Hashtable(int m) {
        n = 0;
        this.m = m;
        table = new Pair[m];
    }

    // returns the value associated with key <key>
    // return null if key is not in table
    // do not forget that you will have to cast the result to (V)
    public V get(K key) {
        if (key == null)
            return null;

        int hash = Math.abs(key.hashCode() % m);
        int originalHash = hash;

        while (table[hash] != null) {
            if (table[hash].getKey().equals(key)) {
                return (V) table[hash].getValue();
            }

            hash = (hash + 1) % m;

            if (hash == originalHash) {
                break;
            }
        }

        return null;
    }

    // puts (key, val) into the table or updates value
    // if the key is already in the table
    // resize to getNextNum(2*m) if (double)n/m exceeds alphaHigh after the insert
    public void put(K key, V val) {
        if (key == null)
            return;

        int hash = Math.abs(key.hashCode() % m);

        while (table[hash] != null) {
            if (table[hash].getKey().equals(key)) {
                table[hash].setValue(val);
                return;
            }

            hash = (hash + 1) % m;
        }

        table[hash] = new Pair<K, V>(key, val);
        ++n;
        if ((double) n / m > alphaHigh) {
            resize(getNextNum(2 * m));
        }
    }

    // removes the (key, value) pair associated with <key>
    // returns the deleted value or null if the element was not in the table
    // resize to getNextNum(m/2) if m/2 >= 11 AND (double)n/m < alphaLow after the
    // delete

    public V delete(K key) {
        if (key == null)
            return null;

        int hash;
        int originalHash;

        hash = Math.abs(key.hashCode() % m);
        originalHash = hash;

        while (table[hash] != null) {
            if (table[hash].getKey().equals(key)) {
                V value = (V) table[hash].getValue();
                table[hash] = null;
                --n;

                // rehashAfterDelete(hash);

                if (m / 2 >= 11 && (double) n / m < alphaLow) {
                    resize(getNextNum(m / 2));
                }

                return value;
            }

            hash = (hash + 1) % m;

            if (hash == originalHash) {
                break;
            }
        }
        return null;
    }

    // return true if table is empty
    public boolean isEmpty() {
        return (n == 0);
    }

    // return the number of (key,value) pairs in the table
    public int size() {
        return n;
    }

    // This method is used for testing only. Do not use this method yourself for any
    // reason
    // other than debugging. Do not change this method.
    public Pair<K, V>[] getTable() {
        return table;
    }

    // PRIVATE

    // gets the next multiple of 6 plus or minus 1,
    // which has a decent probability of being prime.
    // Use this method when resizing the table.
    private int getNextNum(int num) {
        if (num == 2 || num == 3)
            return num;
        int rem = num % 6;
        switch (rem) {
            case 0:
                num++;
                break;
            case 2:
                num += 3;
                break;
            case 3:
                num += 2;
                break;
            case 4:
                num++;
                break;
        }
        return num;
    }

    private void resize(int newSize) {
        Pair<K, V>[] oldTable = table;
        int oldM = m;

        table = new Pair[newSize];
        m = newSize;
        n = 0;

        for (int i = 0; i < oldM; i++) {
            if (oldTable[i] != null) {
                put((K) oldTable[i].getKey(), (V) oldTable[i].getValue());
            }
        }
    }

}

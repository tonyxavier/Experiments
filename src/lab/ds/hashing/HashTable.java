package lab.ds.hashing;

public class HashTable<K, V> {

    private Entry[] table;


    private int capacity;
    private int loadFactor;
    private int size;


    public HashTable() {

        capacity = 50;
        table = new Entry[capacity];
        loadFactor = 75;
        size = 50;

    }

    public HashTable(int initialCapacity, int loadFactor)//load factor as percentage. should be between 10 & 100;
    {
        capacity = initialCapacity;
        table = new Entry[capacity];
        this.loadFactor = loadFactor;
        size = initialCapacity;

    }


    private void rehash() {


        capacity = capacity * 125 / 100;

        Entry[] oldTable = table;

        table = new Entry[capacity];


        for (int i = 1; i <= size; i++) {

            Entry e = oldTable[i];

            if (e != null) {
                do {

                    int indx = e.value.hashCode() % capacity;

                    if (table[indx] == null) {
                        table[indx] = e;
                    } else {

                        Entry temp = table[indx];

                        while (temp.next != null) {
                            temp = temp.next;
                        }

                        temp.next = e;


                    }


                    e = e.next;

                } while (e != null);


            }


        }


    }


    public V put(K k, V v) {

        int hash = k.hashCode();
        int indx = hash % capacity;

        Entry<K, V> e = new Entry<K, V>(k, v, null);

        if (table[indx] == null) {
            table[indx] = e;
            size++;
        } else {

            Entry<K, V> temp = table[indx];


            if (temp.key.equals(k))//key is already present, put the new value and return the old value
            {
                V oldValue = temp.value;
                temp.value = v;

                return oldValue;

            }

            while (temp.next != null) {
                temp = temp.next;

                if (temp.key.equals(k))//key is already present, put the new value and return the old value
                {
                    V oldValue = temp.value;
                    temp.value = v;

                    return oldValue;

                }
            }


            temp.next = e;
            size++;


        }


        //	if(loadFactor>=75)
        //		rehash();


        return null;


    }


    public V get(K key) {

        int hash = key.hashCode();
        int indx = hash % capacity;

        if (table[indx] == null) {
            return null;
        } else {
            Entry<K, V> e = table[indx];

            while (e != null) {

                if (e.key.equals(key))
                    return e.value;
                else
                    e = e.next;

            }


        }

        return null;


    }


    public V remove(K key) {

        int hash = key.hashCode();
        int indx = hash % capacity;

        if (table[indx] == null) {
            return null;
        } else {
            Entry<K, V> e = table[indx];
            Entry prev = e;

            while (e != null) {

                if (e.key.equals(key)) {
                    if (e == prev)//Only one entry exist in the bucket
                    {
                        table[indx] = null;
                        return e.value;

                    } else {
                        prev.next = e.next;
                        return e.value;

                    }

                } else {
                    prev = e;
                    e = e.next;
                }


            }


        }

        return null;


    }


    static class Entry<K, V> {

        final K key;
        V value;

        Entry next;

        Entry(K k, V v, Entry n) {
            key = k;
            value = v;
            next = n;

        }


    }


}

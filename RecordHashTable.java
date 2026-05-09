
public class RecordHashTable {

    private Record[] table;
    private int size;

    public RecordHashTable() {
        table = new Record[20];
        size = 0;
    }

     //Adds a record into the hash table,uses the title as the key.
    public void put(Record r) {

        if ((double) size / table.length >= 0.8) {
            rehash();
        }

        int index = hashFunction(r);

        while (table[index] != null) {
            index = (index + 1) % table.length;
        }

        table[index] = r;
        size++;
    }

     //Removes a record from the hash table.
    public void remove(Record r) {

        int index = hashFunction(r);

        while (table[index] != null) {

            if (table[index].getTitle().equals(r.getTitle())) {
                table[index] = null;
                size--;
                return;
            }

            index = (index + 1) % table.length;
        }
    }

     //Folding hash function using title string.
    public int hashFunction(Record r) {

        String title = r.getTitle();
        int total = 0;

        for (int i = 0; i < title.length(); i += 2) {

            String part = "";

            part += title.charAt(i);

            if (i + 1 < title.length()) {
                part += title.charAt(i + 1);
            }

            total += part.hashCode();
        }

        return Math.abs(total % table.length);
    }
    // Doubles the size of the hash table.
    public void rehash() {

        Record[] oldTable = table;

        table = new Record[oldTable.length * 2];
        size = 0;

        for (int i = 0; i < oldTable.length; i++) {

            if (oldTable[i] != null) {
                put(oldTable[i]);
            }
        }
    }
     //Checks if a record exists in the table.
    public boolean contains(Record r) {

        int index = hashFunction(r);

        while (table[index] != null) {

            if (table[index].getTitle().equals(r.getTitle())) {
                return true;
            }

            index = (index + 1) % table.length;
        }

        return false;
    }

     //Gets a record using the title.
    public Record get(String t) {

        int total = 0;

        for (int i = 0; i < t.length(); i += 2) {

            String part = "";

            part += t.charAt(i);

            if (i + 1 < t.length()) {
                part += t.charAt(i + 1);
            }

            total += part.hashCode();
        }

        int index = Math.abs(total % table.length);

        while (table[index] != null) {

            if (table[index].getTitle().equals(t)) {
                return table[index];
            }

            index = (index + 1) % table.length;
        }

        return null;
    }

     //Returns true if the table is empty.
    
    public boolean isEmpty() {
        return size == 0;
    }

    
     // Returns number of records stored.
     
    public int size() {
        return size;
    }

     //Prints the contents of the hash table.
    public void dump() {

        for (int i = 0; i < table.length; i++) {

            if (table[i] == null) {
                System.out.println(i + ": null");
            }
            else {
                System.out.println(i + ": " +
                        table[i].getTitle() + ", " +
                        table[i].toString());
            }
        }
    }
}
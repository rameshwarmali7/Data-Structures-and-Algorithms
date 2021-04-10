class HashTable {
	final String[] stringArray;
	
	public HashTable(final int size) {
		this.stringArray = new String[size];
	}
	
	public void simpleHashFunction01(final String[] stringsForArray) {
		
		for(String value : stringsForArray) this.stringArray[Integer.valueOf(value)] = value;
		show();
	}
	
	public void simpleHashFunction02(final String[] stringsForArray) {
		
		for(String value : stringsForArray) {
			int index = Integer.parseInt(value) % this.stringArray.length;
			
			while(this.stringArray[index] != null) {
				index++;
				System.out.println("Collision Try " + index);
				index %= this.stringArray.length;
			}

			this.stringArray[index] = value;
		}
		
		show();		
	}
	
	public int findKey(final String key) {
		int indexHash = Integer.parseInt(key) % this.stringArray.length;
		
		while(this.stringArray[indexHash] != null) {
			if(this.stringArray[indexHash] == key) {
				System.out.println(key + " found in index=" + indexHash);
				return indexHash;
			}
			indexHash++;
			indexHash %= this.stringArray.length;
		}
		
		return -1;
	}
	
	public void show() {
		for(int i = 0; i < this.stringArray.length; i++) System.out.print("|" + i + "|" + this.stringArray[i] + "|  ");
		System.out.println();
	}
}

public class HashTableMain {
	
	public static void main(String[] args) {
		
		final HashTable ht01 = new HashTable(10);
		final String[] myArray01 = new String[] {"1", "4", "6"};
		ht01.simpleHashFunction01(myArray01);
		
		final HashTable ht02 = new HashTable(10);
		final String[] myArray02 = new String[] {"452", "210", "27", "56", "78", "91", "62", "23", "45", "77"};
		ht02.simpleHashFunction02(myArray02);
		ht02.findKey("56");
	}
}

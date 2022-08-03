package com.my.hashing;

public class HashTables {
    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;

    public HashTables(int size){
        arraySize =size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    public void  displayTable(){
        System.out.println("Table: ");
        for (int i =0; i < arraySize; i++){
            if (hashArray[i] != null)
                System.out.println(hashArray[i].getiData() + " ");
            else
                System.out.println("** ");
        }
        System.out.println("");
    }

    public int hashFunc(int key){
        return key % arraySize;
    }

    public void insert(DataItem item){
        int key =item.getiData();
        int hashVal = hashFunc(key);

        while (hashArray[hashVal] != null && hashArray[hashVal].getiData() != -1){
            ++hashVal;
            hashVal %=arraySize;
        }
        hashArray[hashVal] = item;
    }

    public DataItem delete(int key){
        int hashVal = hashFunc(key);
        while (hashArray[hashVal]!=  null){
            if (hashArray[hashVal].getiData() == key){
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal%= arraySize;
        }
        return null;
    }

    public DataItem find(int key){
        int hashVal = hashFunc(key);
        while (hashArray[hashVal]!= null){
            if (hashArray[hashVal].getiData() == key)
                return hashArray[hashVal];
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }
}

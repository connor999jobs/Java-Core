package com.my.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class ashTableApp {
    public static void main(String[] args) throws IOException {
        DataItem dataItem;
        int aKey, size, n, keyPerCell;
        System.out.println("Enter size of hashTable: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
        keyPerCell = 10;
        HashTables hashTables = new HashTables(size);
        for (int i = 1; i < n; i++) {
            aKey = (int) (Math.random() * keyPerCell * size);
            dataItem = new DataItem(aKey);
            hashTables.insert(dataItem);
        }
        while (true) // Взаимодействие с пользователем
        {
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, delete, or find: ");
            char choice = getChar();
            switch (choice) {
                case 's':
                    hashTables.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    dataItem = new DataItem(aKey);
                    hashTables.insert(dataItem);
                    break;
                case 'd':
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    hashTables.delete(aKey);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    dataItem = hashTables.find(aKey);
                    if (dataItem != null) {
                        System.out.println("Found " + aKey);
                    } else
                        System.out.println("Could not find " + aKey);
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }
        }
    }

    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    //--------------------------------------------------------------
    public static char getChar() throws IOException
    {
        String s = getString();
        return s.charAt(0);
    }
    //-------------------------------------------------------------
    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }
}

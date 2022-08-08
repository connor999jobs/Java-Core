package com.my.stream.example3;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private List<Reader> readers;

    public Library() {
        init();
    }

    public Library(List<Book> books, List<Reader> readers) {
        this.books = books;
        this.readers = readers;
    }

    private void init() {
        books = new ArrayList<>();
        books.add(new Book("Оруэлл", "1984", 2021));
        books.add(new Book("Alain Mabanckou", "Broken Glass", 2005));
        books.add(new Book("Stieg Larsson", "The Girl With the Dragon Tattoo", 2008));
        books.add(new Book("Hanya Yanagihara", "A Little Life", 2015));
        //и так далее для других книг

        readers = new ArrayList<>();
        readers.add(new Reader("Иванов Иван Иванович", "ivanov.email@test.ru", true));
        readers.add(new Reader("Vadym Kostenko","konnor999", true));
        readers.add(new Reader("Andey Demchenko","digitalDD", true));
        readers.add(new Reader("Dima Izotov","Elee62", false));
        //и так далее для других читателей

        readers.get(0).getBooks().add(books.get(0));

        readers.get(1).getBooks().add(books.get(1));
        readers.get(1).getBooks().add(books.get(2));
        readers.get(1).getBooks().add(books.get(3));

        readers.get(2).getBooks().add(books.get(2));

        readers.get(3).getBooks().add(books.get(3));
        readers.get(3).getBooks().add(books.get(2));

        //и так далее для других читателей и взятых книг
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    @Override
    public String toString() {
        return "Library{" + "\n" +
                "books=" +  books + "\n" +
                ", readers=" + readers + "\n" +
                '}';
    }
}
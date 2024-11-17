package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Effective Java", 416);
        Book book2 = new Book("Clean Code", 464);
        Book book3 = new Book("Cucumber Design", 395);
        Book book4 = new Book("Software Project Management", 560);

        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;

        System.out.println("Первоначальный список книг:");
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getPages() + " страниц");
        }

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        System.out.println("Список книг после перестановки:");
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getPages() + " страниц");
        }

        System.out.println("Книга с названием 'Clean Code':");
        for (int i = 0; i < books.length; i++) {
            if ("Clean Code".equals(books[i].getName())) {
                System.out.println(books[i].getName() + " - " + books[i].getPages() + " страниц");
            }
        }
    }
}
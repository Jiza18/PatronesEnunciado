abstract class Product {
    protected String title;
    protected double price;

    public Product(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public abstract void display();
}

class Book extends Product {
    protected String author;

    public Book(String title, double price, String author) {
        super(title, price);
        this.author = author;
    }

    @Override
    public void display() {
        System.out.println("Book - Title: " + title + ", Author: " + author + ", Price: " + price);
    }
}

class Electronic extends Product {
    protected String manufacturer;

    public Electronic(String title, double price, String manufacturer) {
        super(title, price);
        this.manufacturer = manufacturer;
    }

    @Override
    public void display() {
        System.out.println("Electronic - Title: " + title + ", Manufacturer: " + manufacturer + ", Price: " + price);
    }
}

class Clothing extends Product {
    protected String size;

    public Clothing(String title, double price, String size) {
        super(title, price);
        this.size = size;
    }

    @Override
    public void display() {
        System.out.println("Clothing - Title: " + title + ", Size: " + size + ", Price: " + price);
    }
}


public class Main {
    public static void main(String[] args) {
        Product book = new Book("Harry Potter and the Philosopher's Stone", 9.99, "J.K. Rowling");
        book.display();

        Product electronic = new Electronic("iPhone 12 Pro", 999.99, "Apple");
        electronic.display();

        Product clothing = new Clothing("Maxi Dress", 38, "ASOS");
        clothing.display();
    }
}
/*Crea una clase Factory para los siguientes productos.

En el programa principal, sustiuye las llamadas a los constructores por llamadas al método factory.

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
}*/

enum Tipos {
    BOOK,ELEC,PUBL;
}

abstract class Product {
    protected String title;
    protected double price;

    public Product(String title, double price) {
        this.title = title;
        this.price = price;
    }
    public abstract void display();

    static Product factory(Tipos tipo, String title, double price, String carastericas) {

        switch (tipo) {
            case BOOK:
                return new Book(title, price, carastericas);
            case ELEC:
                return new Electronic(title,price,carastericas);
            case PUBL:
                return new Clothing(title,price,carastericas);
        }

        return null;
    }
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

        Product book = Product.factory(Tipos.BOOK, "Harry Potter and the Philosopher's Stone", 9.99, "J.K. Rowling");
        book.display();

        Product electronic = Product.factory(Tipos.ELEC,"iPhone 12 Pro", 999.99, "Apple");
        electronic.display();

        Product clothing = Product.factory(Tipos.PUBL,"Maxi Dress", 38, "ASOS");
        clothing.display();
    }
}
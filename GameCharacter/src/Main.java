/*Crea una classe Factory llamada CharacterFactory para los siguientes personajes de un juego:

abstract class Character {
    protected String name;
    protected int health;
    protected int speed;

    public Character(String name, int health, int speed) {
        this.name = name;
        this.health = health;
        this.speed = speed;
    }

    public abstract void move();
    public abstract void attack();
    public abstract void die();
}

class Knight extends Character {

    public Knight(String name, int health, int speed) {
        super(name, health, speed);
    }

    @Override
    public void move() {
        System.out.println("Knight is moving...");
    }

    @Override
    public void attack() {
        System.out.println("Knight is attacking...");
    }

    @Override
    public void die() {
        System.out.println("Knight died...");
    }
}

class Wizard extends Character {

    public Wizard(String name, int health, int speed) {
        super(name, health, speed);
    }

    @Override
    public void move() {
        System.out.println("Wizard is moving...");
    }

    @Override
    public void attack() {
        System.out.println("Wizard is attacking...");
    }

    @Override
    public void die() {
        System.out.println("Wizard died...");
    }
}


public class Main {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();

        // create a knight
        Character knight = factory.createCharacter("knight", "Arthur", 100, 5);
        knight.move();
        knight.attack();
        knight.die();

        // create a wizard
        Character wizard = factory.createCharacter("wizard", "Gandalf", 80, 7);
        wizard.move();
        wizard.attack();
        wizard.die();
    }
}
*/

enum Tipos {
    KNT,WIZ;
}

abstract class Character {
    protected String name;
    protected int health;
    protected int speed;

    public Character(String name, int health, int speed) {
        this.name = name;
        this.health = health;
        this.speed = speed;
    }

    public abstract void move();
    public abstract void attack();
    public abstract void die();
}

class CharacterFactory{

    static Character createCharacter(Tipos tipos, String name, int health, int speed) {

        switch (tipos) {
            case KNT:
                return new Knight(name,health,speed);
            case WIZ:
                return new Wizard(name,health,speed);
        }

        return null;
    }

}

class Knight extends Character {

    public Knight(String name, int health, int speed) {
        super(name, health, speed);
    }

    @Override
    public void move() {
        System.out.println("Knight is moving...");
    }

    @Override
    public void attack() {
        System.out.println("Knight is attacking...");
    }

    @Override
    public void die() {
        System.out.println("Knight died...");
    }
}

class Wizard extends Character {

    public Wizard(String name, int health, int speed) {
        super(name, health, speed);
    }

    @Override
    public void move() {
        System.out.println("Wizard is moving...");
    }

    @Override
    public void attack() {
        System.out.println("Wizard is attacking...");
    }

    @Override
    public void die() {
        System.out.println("Wizard died...");
    }
}


public class Main {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();

        // create a knight
        Character knight = factory.createCharacter(Tipos.KNT, "Arthur", 100, 5);
        knight.move();
        knight.attack();
        knight.die();

        // create a wizard
        Character wizard = factory.createCharacter(Tipos.WIZ, "Gandalf", 80, 7);
        wizard.move();
        wizard.attack();
        wizard.die();
    }
}
package ru.netology.domain;

public class Player {
    protected int id;
    protected String name;
    protected int strength;

    public Player(int id, String name, int strength) {
        this.id = id;
        this.name = name;
        this.strength = strength;
    }

//    public int getId() {
//        return id;
//    }

    public String getName() {
        return name;
    }

//    public int getStrength() {
//        return strength;
//    }

    public int compareTo(Player o) {
        if (this.strength > o.strength) {
            return 1;
        } else if (this.strength < o.strength) {
            return 2;
        } else {
            return 0;
        }
    }
}

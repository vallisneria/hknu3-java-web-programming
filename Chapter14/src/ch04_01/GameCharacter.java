package ch04_01;

import java.io.*;

public class GameCharacter implements Serializable {
    int power;
    String type;
    String[] weapons;

    public GameCharacter(int power, String type, String[] weapons) {
        this.power = power;
        this.type = type;
        this.weapons = weapons;
    }

    public int getPower() {
        return this.power;
    }

    public String getType() {
        return this.type;
    }

    public String getWeapons() {
        String result = "";

        for (int i = 0; i < this.weapons.length; i++) {
            result += this.weapons[i] + " ";
        }
        return result;
    }
}

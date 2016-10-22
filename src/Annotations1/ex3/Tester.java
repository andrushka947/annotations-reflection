package Annotations1.ex3;


import java.io.Serializable;

public class Tester implements Serializable {

    Tester() {}

    @Save
    private String name;

    @Save
    public int age;

    @Save
    public double pi;

    @Save
    public char character;

    private char character1;

    public String srt;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPi() {
        return pi;
    }

    public void setPi(double pi) {
        this.pi = pi;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public char getCharacter1() {
        return character1;
    }

    public void setCharacter1(char character1) {
        this.character1 = character1;
    }

    public String getSrt() {
        return srt;
    }

    public void setSrt(String srt) {
        this.srt = srt;
    }
}

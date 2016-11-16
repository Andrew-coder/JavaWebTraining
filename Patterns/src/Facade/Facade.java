package Facade;

/**
 * Created by andri on 11/16/2016.
 */
class Power {
    public void on() {
        System.out.println("Power is turned on");
    }
    public void off() {
        System.out.println("Power is turned off");
    }
}

class DVDRom {
    private boolean data = false;
    public boolean hasData() {
        return data;
    }

    public void load(){
        data = true;
    }

    public void unload() {
        data = false;
    }
}

class HDD {
    public void copyDataFromDvd(DVDRom dvd) {
        if(dvd.hasData()) {
            System.out.println("data backup");
        }
        else {
            System.out.println("dvd is unload!");
        }
    }
}

class Computer {
    Power power;
    DVDRom dvd;
    HDD hdd;

    public Computer() {
        power = new Power();
        dvd = new DVDRom();
        hdd=new HDD();
    }

    public void copy(){
        power.on();
        dvd.load();
        hdd.copyDataFromDvd(dvd);
    }
}

class Main {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.copy();
    }
}
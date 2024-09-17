package Creational;

import Creational.builder.Computer;
import Creational.singleton.Singleton;

public class main {
    public static void main(String[] args) {
//        Singleton s1 = Singleton.getInstance();
//        Singleton s2 = Singleton.getInstance();
//        System.out.println(s1);
//        System.out.println(s2);

//        Builder Pattern instance
//        Computer myComputer = new Computer.Builder()
//                .build();
        Computer myComputer = new Computer.Builder()
                .setCPU("Intel i7")
                .setGPU("NVIDIA GTX 1080")
                .setRAM(16)
                .setStorage(512)
                .build();

        System.out.println( myComputer.toString());
    }
}

package Creational.builder;

public class Computer {
    private String CPU;
    private String GPU;
    private int RAM;
    private int storage;

    public Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.GPU = builder.GPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
    }
    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", GPU=" + GPU + ", RAM=" + RAM + "GB, storage=" + storage + "GB]";
    }
    public static class Builder{
        private String CPU;
        private String GPU;
        private int RAM;
        private int storage;
        public Computer build() {
            return new Computer(this);
        }

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Builder setRAM(int RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }
    }
}

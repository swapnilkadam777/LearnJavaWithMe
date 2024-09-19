package SingleResponsibilityPrinciple;

public class owl extends Birds{
    public owl(String name) {
        super(name);
    }

    public void sound(){
        System.out.println(this.getName() + "owl sound");
    };
}

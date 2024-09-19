package SingleResponsibilityPrinciple;

public abstract class Birds {
    private  String name;

    public String getName() {
        return name;
    }

    public Birds(String name) {
        this.name = name;
    }
    public void sound(){
        System.out.println(name + " no sound");
    };

    //try to avoid multiple if else
    public void sound2() {
        if(this.name.equals("owl")){
            System.out.println(name + "owl sound");
        } else if(this.name.equals("Pigen")){
            System.out.println(name + "pigeon sound");
        }else{
            System.out.println(name + " no sound");
        }
    }
}

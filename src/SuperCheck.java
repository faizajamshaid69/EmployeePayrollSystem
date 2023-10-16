 class Animal{
    String color="white";
}
class Dog extends Animal{
    String color="brown";
    public void print(){

        System.out.println(super.color+" "+color);
    }

}
public class SuperCheck {
    public static void main(String[] args) {
        Dog d=new Dog();
        System.out.println(d.color);
        d.print();
    }

}

public class OOPS3 {
     public static void main(String[] args) {
          Horse h=new Horse();
          h.eat();
          h.walk();
          System.out.println(h.color);

          Chicken c=new Chicken();
          c.eat();
          c.walk();
     }
}

abstract class Animal {
     String color;
     Animal(){
          color="brown";
     }
     void eat(){
          System.out.println("eats");
     }
     abstract void walk();
}

class Horse extends Animal{
     void changeColor(){
          color="white";
     }
     void walk(){
          System.out.println("walks on four legs");
     }
}

class Chicken extends Animal{
     void walk(){
          System.out.println("walks on two legs");
     }
}
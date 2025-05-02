public class OOPS{
     public static void main(String[] args) {
          // Pen p1=new Pen();//PEN OBJECT
          // p1.setColor("blue");
          // System.out.println(p1.getColor());
          // p1.setTip(4);
          // System.out.println(p1.getTip());

          // Student s1=new Student("hamza");
          Student s2=new Student();
          // Student s3=new Student(44);
          s2.name="hamza";
          s2.roll=44;
          s2.password="abcd";
          s2.marks[0]=33;
          s2.marks[1]=67;
          s2.marks[2]=12;

          Student s3=new Student(s2);
          s3.password="xyz";
          s2.marks[2]=99;
          for(int i=0;i<3;i++){
               System.out.println(s3.marks[i]);
          }
          // BankAccount myAcc=new BankAccount();
          // myAcc.username="hamza";
          // // myAcc.password="abcd"; YE NAHI CHALEGA PRIVATE HAI
          // myAcc.setPassword("killme");
          // // PASSWORD ACCESS NHI HOGA YAHA SE 
  }
}

class Student{
     String name;
     int roll;
     String password;
     int marks[];

     //shallow COPY CONSTRUCTOR
     // Student(Student s2){
     //      marks=new int[3];
     //      this.name=s2.name;
     //      this.roll=s2.roll;
     //      this.marks=s2.marks;
     // }

     // deep copy constructor
     Student(Student s2){
          marks=new int[3];
          this.name=s2.name;
          this.roll=s2.roll;
          for(int i=0;i<3;i++){
               this.marks[i]=s2.marks[i];
          }
     }

     Student(){
          marks=new int[3];
          System.out.println("constructor called");
     }
     Student(String name){
          marks=new int[3];
          this.name=name;
     }
     Student(int roll){
          marks=new int[3];
          this.roll=roll;
     }
}

class BankAccount{
     public String username;
     private String password;
     public void setPassword(String pwd){
          password=pwd;
     }
}

class Pen{
     private String color;
     private int tip;

     String getColor(){
          return this.color;
     }
     int getTip(){
          return this.tip;
     }

     void setColor(String newColor){
          color=newColor;
     }
     void setTip(int tip){
          this.tip=tip;
     }
}


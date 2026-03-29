public class User {
    String name;
    String email;
    int age;
    // every user has a name , email and age so this is a user blueprint.
    User(String name,String email,int age){
        this.name=name;
        this.email=email;
        this.age=age;
        // this.name=name  means the value in the "name" from the constructor is referencing to the class variable   
    }
    void printDetails(){ // void means this method did not return anything
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Age: " + age);
    }
}

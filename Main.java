public class Main {
    public static void main(String[] args) {
        User user1 = new User("Rahul","rahul@gmail.com",20); // created a object or an actual  user from the class blueprint of the user class .
        // user1.name = "Rahul"; // username 
        // user1.email = "rahul@gmail.com";  // user email
        // user1.age = 20;  //  user age 
        // the above is the manual creation of the user object and assignment of data .
        // but in real world there are thousands of users of it becomes messy and time com=nsuming to crete manually objects so  a constructor lets you do it in 1 line..(changes done in User class )
        

        // printing all the details of the user 
        // instead of writing the Sopln 3 times , we 
        // just call the printDetails() -> one line does everyting , so this is called reusability od code.
        user1.printDetails();


        User user2=new User("Priya","priya@gmail.com",19);
        // user2.name="priya";
        // user2.email="Priya@gmail.com";
        // user2.age=19;

        user2.printDetails();

        // creating job object 
        Job job1=new Job("Backend developer Intern","Build REST APIs using Spring Boot");
        // job1.title="Backend developer Intern";
        // job1.description="Build REST APIs using Spring Boot";
        job1.printDetails();

        Application a1=new Application("anant", "Backend Developer Intern", "selected ");
        a1.printDetails();
    }
}

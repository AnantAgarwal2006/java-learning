public class Job {
    String title;
    String description;
    // the above is the blueprint of the job object

    Job(String title,String description){
        this.title=title;
        this.description=description;
    }
    void printDetails(){
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
    }
}

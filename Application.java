public class Application {
    String applicantName;
    String jobTitle;
    String status; //(value=="applied,rejected,pending")

    Application(String applicantName,String jobTitle,String status) {
        this.applicantName=applicantName;
        this.jobTitle=jobTitle;
        this.status=status;
    }

    void printDetails(){
        System.out.println("Applicant :" + applicantName);
        System.out.println("Job Title :"+ jobTitle);
        System.out.println("Status :"+ status);
    }
}

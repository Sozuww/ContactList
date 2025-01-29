public class Worker extends Person {

    // Instance Variables
    private String job;

    public Worker (String firstName, String lastName, String phoneNumber, String job)
    {
        super (firstName, lastName, phoneNumber);
        this.job = job;

    }

    // Getters and Setters
    public String getJob()
    {
        return job;
    }

    public void setJob(String job)
    {
        this.job = job;
    }


    public String toString()
    {
        return super.toString() + " Job Title: " + job;
    }

}

public class Empp {
    private String name;
    private String presentAddress;
    private String pastAddress;
    private String nid;
    private String passport;
    private String joiningDate;
    private String educationStatus;
    private double salary;

    public Empp(String name, String presentAddress, String pastAddress, String nid, String passport, String joiningDate, String educationStatus, double salary) {
        this.name = name;
        this.presentAddress = presentAddress;
        this.pastAddress = pastAddress;
        this.nid = nid;
        this.passport = passport;
        this.joiningDate = joiningDate;
        this.educationStatus = educationStatus;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getPastAddress() {
        return pastAddress;
    }

    public void setPastAddress(String pastAddress) {
        this.pastAddress = pastAddress;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getEducationStatus() {
        return educationStatus;
    }

    public void setEducationStatus(String educationStatus) {
        this.educationStatus = educationStatus;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
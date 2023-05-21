class Worker {
    String name;
    String presentAddress;
    String pastAddress;
    String NID;
    String passport;
    String joiningDate;
    String educationStatus;
    double salary;

    public Worker(String name, String presentAddress, String pastAddress, String NID, String passport, String joiningDate, String educationStatus, double salary) {
        this.name = name;
        this.presentAddress = presentAddress;
        this.pastAddress = pastAddress;
        this.NID = NID;
        this.passport = passport;
        this.joiningDate = joiningDate;
        this.educationStatus = educationStatus;
        this.salary = salary;
    }

    public String toString() {
        return "Name: " + name + ", Present Address: " + presentAddress + ", Past Address: " + pastAddress + ", NID: " + NID + ", Passport: " + passport + ", Joining Date: " + joiningDate + ", Education Status: " + educationStatus + ", Salary: " + salary;
    }
}

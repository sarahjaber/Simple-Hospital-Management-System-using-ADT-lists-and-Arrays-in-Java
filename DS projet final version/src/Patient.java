public class Patient {
    String firstName;
    String lastName;
    int patientID;
    String admissionDate;
    String city;
    String dateBirth;
    String severity;

    public Patient(String firstName, String lastName, int patientId, String admissionDate, String city, String dateBirth, String severity){
        this.firstName=firstName;
        this.lastName=lastName;
        this.patientID=patientId;
        this.admissionDate=admissionDate;
        this.city=city;
        this.dateBirth=dateBirth;
        this.severity=severity;
    }
    public String toString(){
        return "PATIENT: "+firstName+" "+lastName+", "+patientID+", "+admissionDate+", "+city+", "+dateBirth+", "+severity+".";
    }
}

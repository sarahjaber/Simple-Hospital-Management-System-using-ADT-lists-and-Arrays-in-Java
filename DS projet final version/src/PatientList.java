public class PatientList implements hospitalInterface{
    Patient patient [];
    int length;
    private static int MAX_SIZE=30;

    public PatientList(){
        length=0;
        patient = new Patient[MAX_SIZE];
    }
    private boolean isHospitalFull(){
        return length == patient.length;
    }
    private void doubleHospital(){
        Patient [] oldPatient = patient;
        int oldLength = patient.length;
        patient = new Patient[oldLength*2];
        for(int i = 0; i<oldLength; i++){
            patient[i] = oldPatient[i];
        }
    }
    public boolean addPatient(Patient newPatient){
        if(isHospitalFull()){
            doubleHospital();
        }
        patient[length]=newPatient;
        length++;
        return true;
    }
    public boolean isFull(){
        return length == patient.length;
    }
    public boolean isEmpty(){
        return length==0;
    }
    public void display(){
        for(int i=0; i<length; i++){
            System.out.println(patient[i]);
        }
    }
    public boolean contains(Patient aPatient){
        boolean foundPatient=true;
        for(int index=0; index<length; index++){
            if(aPatient.equals(patient[index])){
                foundPatient = true;
            }
            foundPatient = false; 
        }
        return foundPatient; 
    }
    public int getLength() {
        return length; //for actual number of patients
    }
    
    public Patient getEntry(int index) {
        if (index >= 0 && index < length) {
            return patient[index];
        }
        return null;
    }

}

public class DStack implements StackInterface {
    Object[] patient;
    int topIndex;
    final static int MAX_SIZE = 30;

    DStack() {
        patient = new Object[MAX_SIZE];
        topIndex = -1;
    }

    private boolean isHospitalFull() {
        return topIndex + 1 == patient.length; // Checks if the stack is full
    }

    private void doubleHospital() {
        Object[] oldPatient = patient;
        int oldIndex = patient.length;
        patient = new Object[oldIndex * 2]; 
        for (int i = 0; i < oldIndex; i++) {
            patient[i] = oldPatient[i]; // Copies elements to the new array
        }
    }

    public void push(Object newEntry) {
        if (isHospitalFull()) {
            doubleHospital();
        }
        topIndex++;  // Increments the top before adding the new patient
        patient[topIndex] = newEntry;
    }

    public Object peek() {
        if (!isEmpty()) {
            return patient[topIndex];
        }
        return null;
    }

    public Object pop() {
        Object result = null;
        if (!isEmpty()) {
            result = patient[topIndex];
            patient[topIndex] = null;
            topIndex--; // Decrements the top after removing the patient/element
        }
        return result;
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    public void clear() {
        topIndex = -1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("NONE");
        } else {
            System.out.println(" ");
            for (int i = 0; i <= topIndex; i++) { 
                System.out.println(patient[i]);
            }
    }
}
}
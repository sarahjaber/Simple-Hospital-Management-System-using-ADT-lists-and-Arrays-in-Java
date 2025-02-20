public interface hospitalInterface {
    public boolean addPatient(Patient newPatient);
    public boolean isEmpty();
    public boolean isFull();
    public void display();
    public boolean contains(Patient aPatient);
    public int getLength();
    public Patient getEntry(int index);
    
}

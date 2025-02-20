import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class App {
    public static void main(String[] args) throws Exception {
        PatientList hospital = new PatientList();
        String filePath = "patients.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length < 7) continue; // Ensure correct number of fields
                String firstName = parts[0];
                String lastName = parts[1];
                int patientID = Integer.parseInt(parts[2]);
                String admissionDate = parts[3];
                String city = parts[4];
                String dateBirth = parts[5];
                String severity = parts[6];
                Patient patient = new Patient(firstName, lastName, patientID, admissionDate, city, dateBirth, severity);
                hospital.addPatient(patient);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        // Display all patients
        System.out.println("------------------------ALL PATIENT LIST---------------------");
        hospital.display();

        // Categorizing patients by city
        PatientList ammanP = new PatientList();
        PatientList mafraqP = new PatientList();
        PatientList irbidP = new PatientList();
        PatientList karakP = new PatientList();
        PatientList maanP = new PatientList();
        PatientList madabaP = new PatientList();
        PatientList tafelahP = new PatientList();
        PatientList aqabaP = new PatientList();
        for (int i = 0; i < hospital.getLength(); i++) {
            Object entry = hospital.getEntry(i);
            if (entry == null) continue;
            Patient p = (Patient) entry;
            if (p.city.equals("Amman")) {
                ammanP.addPatient(p);
            } else if (p.city.equals("Mafraq")) {
                mafraqP.addPatient(p);
            } else if (p.city.equals("Irbid")) {
                irbidP.addPatient(p);
            } else if (p.city.equals("Karak")) {
                karakP.addPatient(p);
            } else if (p.city.equals("Maan")) {
                maanP.addPatient(p);
            } else if (p.city.equals("Madaba")) {
                madabaP.addPatient(p);
            } else if (p.city.equals("Tafelah")) {
                tafelahP.addPatient(p);
            } else if (p.city.equals("Aqaba")) {
                aqabaP.addPatient(p);
            }
        }
        System.out.println("\n------------------------LIST OF AMMAN PATIENTS---------------------");
        ammanP.display();
        System.out.println("\n------------------------LIST OF MAFRAQ PATIENTS---------------------");
        mafraqP.display();
        System.out.println("\n------------------------LIST OF IRBID PATIENTS---------------------");
        irbidP.display();
        System.out.println("\n------------------------LIST OF KARAK PATIENTS---------------------");
        karakP.display();
        System.out.println("\n------------------------LIST OF MAAN PATIENTS---------------------");
        maanP.display();
        System.out.println("\n------------------------LIST OF MADABA PATIENTS---------------------");
        madabaP.display();
        System.out.println("\n------------------------LIST OF TAFELAH PATIENTS---------------------");
        tafelahP.display();
        System.out.println("\n------------------------LIST OF AQABA PATIENTS---------------------");
        aqabaP.display();

        //  "High" severity patients(processing)
        LQueue ammanQueue = new LQueue();
        LQueue mafraqQueue = new LQueue();
        LQueue irbidQueue = new LQueue();
        LQueue karakQueue = new LQueue();
        LQueue maanQueue = new LQueue();
        LQueue madabaQueue = new LQueue();
        LQueue tafelahQueue = new LQueue();
        LQueue aqabaQueue = new LQueue();
        for (int i = 0; i < ammanP.getLength(); i++) {
            Patient patient = (Patient) ammanP.getEntry(i);
            if (patient.severity.equals("High")) {
                ammanQueue.enqueue(patient);
            }
        }
        for (int i = 0; i < mafraqP.getLength(); i++) {
            Patient patient = (Patient) mafraqP.getEntry(i);
            if (patient.severity.equals("High")) {
                mafraqQueue.enqueue(patient);
            }
        }
        for (int i = 0; i < irbidP.getLength(); i++) {
            Patient patient = (Patient) irbidP.getEntry(i);
            if (patient.severity.equals("High")) {
                irbidQueue.enqueue(patient);
            }
        }
        for (int i = 0; i < karakP.getLength(); i++) {
            Patient patient = (Patient) karakP.getEntry(i);
            if (patient.severity.equals("High")) {
                karakQueue.enqueue(patient);
            }
        }
        for (int i = 0; i < maanP.getLength(); i++) {
            Patient patient = (Patient) maanP.getEntry(i);
            if (patient.severity.equals("High")) {
                maanQueue.enqueue(patient);
            }
        }
        for (int i = 0; i < madabaP.getLength(); i++) {
            Patient patient = (Patient) madabaP.getEntry(i);
            if (patient.severity.equals("High")) {
                madabaQueue.enqueue(patient);
            }
        }
        for (int i = 0; i < tafelahP.getLength(); i++) {
            Patient patient = (Patient) tafelahP.getEntry(i);
            if (patient.severity.equals("High")) {
                tafelahQueue.enqueue(patient);
            }
        }
        for (int i = 0; i < aqabaP.getLength(); i++) {
            Patient patient = (Patient) aqabaP.getEntry(i);
            if (patient.severity.equals("High")) {
                aqabaQueue.enqueue(patient);
            }
        }

        System.out.println("\n------------------------HIGH SEVERITY QUEUES---------------------");
        System.out.println("\nAmman High Severity Level:");
        ammanQueue.display();
        System.out.println("\nMafraq High Severity Level:");
        mafraqQueue.display();
        System.out.println("\nIrbid High Severity Level:");
        irbidQueue.display();
        System.out.println("\nKarak High Severity Level:");
        karakQueue.display();
        System.out.println("\nMaan High Severity Level:");
        maanQueue.display();
        System.out.println("\nMadaba High Severity Level:");
        madabaQueue.display();
        System.out.println("\nTafelah High Severity Level:");
        tafelahQueue.display();
        System.out.println("\nAqaba High Severity Level:");
        aqabaQueue.display();


        // Processing patients with "Simple" severity
        DStack ammanStack = new DStack();
        DStack mafraqStack = new DStack();
        DStack irbidStack = new DStack();
        DStack karakStack = new DStack();
        DStack maanStack = new DStack();
        DStack madabaStack = new DStack();
        DStack tafelahStack = new DStack();
        DStack aqabaStack = new DStack();
        for (int i = 0; i < ammanP.getLength(); i++) {
            Patient patient = (Patient) ammanP.getEntry(i);
            if (patient.severity.equals("Simple")) {
                ammanStack.push(patient);
            }
        }
        for (int i = 0; i < mafraqP.getLength(); i++) {
            Patient patient = (Patient) mafraqP.getEntry(i);
            if (patient.severity.equals("Simple")) {
                mafraqStack.push(patient);
            }
        }
        for (int i = 0; i < irbidP.getLength(); i++) {
            Patient patient = (Patient) irbidP.getEntry(i);
            if (patient.severity.equals("Simple")) {
                irbidStack.push(patient);
            }
        }for (int i = 0; i < karakP.getLength(); i++) {
            Patient patient = (Patient) karakP.getEntry(i);
            if (patient.severity.equals("Simple")) {
                karakStack.push(patient);
            }
        }
        for (int i = 0; i < maanP.getLength(); i++) {
            Patient patient = (Patient) maanP.getEntry(i);
            if (patient.severity.equals("Simple")) {
                maanStack.push(patient);
            }
        }
        for (int i = 0; i < madabaP.getLength(); i++) {
            Patient patient = (Patient) madabaP.getEntry(i);
            if (patient.severity.equals("Simple")) {
                madabaStack.push(patient);
            }
        }
        for (int i = 0; i < tafelahP.getLength(); i++) {
            Patient patient = (Patient) tafelahP.getEntry(i);
            if (patient.severity.equals("Simple")) {
                tafelahStack.push(patient);
            }
        }
        for (int i = 0; i < aqabaP.getLength(); i++) {
            Patient patient = (Patient) aqabaP.getEntry(i);
            if (patient.severity.equals("Simple")) {
                aqabaStack.push(patient);
            }
        }

        System.out.println("\n------------------------LOW/SIMPLE SEVERITY STACKS---------------------");
        System.out.println("\nAmman Low/Simple Severity Level:");
        ammanStack.display();
        System.out.println("\nMafraq Low/Simple Severity Level:");
        mafraqStack.display();
        System.out.println("\nIrbid Low/Simple Severity Level:");
        irbidStack.display();
        System.out.println("\nKarak Low/Simple Severity Level:");
        karakStack.display();
        System.out.println("\nMaan Low/Simple Severity Level:");
        maanStack.display();
        System.out.println("\nMadaba Low/Simple Severity Level:");
        madabaStack.display();
        System.out.println("\nTafelah Low/Simple Severity Level:");
        tafelahStack.display();
        System.out.println("\nAqaba Low/Simple Severity Level:");
        aqabaStack.display();

        // Treat patients and display treated list
        PatientList servedP = new PatientList();
        treatPatients(ammanQueue, servedP);
        treatPatients(mafraqQueue, servedP);
        treatPatients(irbidQueue, servedP);
        treatPatients(karakQueue, servedP);
        treatPatients(maanQueue, servedP);
        treatPatients(madabaQueue, servedP);
        treatPatients(tafelahQueue, servedP);
        treatPatients(aqabaQueue, servedP);

        System.out.println("\n------------------------TREATED PATIENTS---------------------");
        printServed(servedP, servedP.getLength() - 1);

        double cost = totalCost(hospital);
        System.out.println("\n-----------------------------------------------------");
        System.out.println("Total cost incurred in treating all patients: $"+cost);
    }

    private static void treatPatients(LQueue queue, PatientList servedList) {
        while (!queue.isEmpty()) {
            Patient p = (Patient) queue.dequeue();
            p.severity = "TREATED";
            servedList.addPatient(p);
        }
    }

    private static String printServed(PatientList served, int size) {
        if (size < 0) {
            return "";
        } else {
            System.out.println(served.getEntry(size));
            return printServed(served, size - 1);
        }
    }
    public static double totalCost(PatientList hospital){
        double cost = 0;

        for(int i=0; i<hospital.getLength(); i++){
            Patient currentPatient = (Patient) hospital.getEntry(i);
            cost += calculatePatientCost(currentPatient);
        }
        return cost;
    }
    public static double calculatePatientCost(Patient patient){
        double patientCost = 0;

        if(patient.severity.equals("Simple")){
            patientCost = 185;
        }
        else if (patient.severity.equals("Average")){
            patientCost = 365;
        }
        else if (patient.severity.equals("High")){
            patientCost = 770;
        }
        return patientCost;
    }

}

// Adding patients to the hospital
        // Patient h1 = new Patient("Sarah", "Jaber", 111111, "11-12-2024", "Amman", "06-05-2003", "Simple");
        // Patient h2 = new Patient("Linda", "Khateeb", 29343, "11-12-2024", "Irbid", "07-02-2004", "Average");
        // Patient h3 = new Patient("Leena", "Shehadeh", 202220234, "17-12-24", "Amman", "04-06-2004", "Simple");
        // Patient h4 = new Patient("Mahmoud", "AlSaleh", 202210034, "17-12-2024", "Amman", "05-10-2004", "High");
        // Patient h5 = new Patient("Fatima", "Jaradat", 1011, "16-12-2024", "Mafraq", "2-02-2002", "Average");
        // Patient h6 = new Patient("Nadia", "Odeh", 1234, "22-12-2024", "Irbid", "12-10-2002", "High");
        // Patient h7 = new Patient("Samer", "Shaheen", 33244, "19-12-2024", "Mafraq", "02-05-2000", "High");
        // Patient h8 = new Patient("Ziad", "Darwish", 44322, "14-12-2024", "Amman", "05-07-2003", "Average");
        // Patient h9 = new Patient("Abeer", "Gharaibeh", 1015, "15-12-2024", "Irbid", "09-09-2009", "Simple");
        // Patient h10 = new Patient("Jad", "Anabtawi", 2024, "17-12-2024", "Mafraq", "25-01-2003", "High");
        // Patient h11 = new Patient("Sara", "Faraj", 1024, "11-12-2024", "Amman", "28-02-1999", "Simple");
        // Patient h12 = new Patient("Nada", "Haddad", 1025, "17-12-2024", "Mafraq", "05-10-2004", "High");

        // hospital.addPatient(h1);
        // hospital.addPatient(h2);
        // hospital.addPatient(h3);
        // hospital.addPatient(h4);
        // hospital.addPatient(h5);
        // hospital.addPatient(h6);
        // hospital.addPatient(h7);
        // hospital.addPatient(h8);
        // hospital.addPatient(h9);
        // hospital.addPatient(h10);
        // hospital.addPatient(h11);
        // hospital.addPatient(h12);

import java.util.*;

class Patient{
    private String name , mobileNo , address , disease;
    private int priority;
    public ArrayList<Patient> p = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Patient(){}

    public Patient(String name , String disease , int priority){
        this.name = name;
        this.disease = disease;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Patient Name: "+this.name+" || Disease: "+this.disease+" || with Priority: "+this.priority ;
    }

    // Menu Methods
    public void addPatient(String name, String disease , int priority){
        if(name == null || disease == null || priority == 0){
            System.out.println("All fields are mandatory to fill..!!");
            return;
        }
        p.add(new Patient(name , disease , priority));
        System.out.println(name.toUpperCase() + " added Successfully as a Patient...");
        p.sort(new PatientPriorityComparator());
    }

    public void removePatient(String name){
        for(Patient pt : p){
            if(pt.getName().equalsIgnoreCase(name)){
                p.remove(pt);
                System.out.println(name.toUpperCase() + " removed Successfully...");
                return;
            }
        }
        System.out.println("*No entry exists for this patient..!");
    }

    public void searchPatient(String name){
        if(p.isEmpty()){
            System.out.println("*No patients for Now..!");
            return;
        }
        for(Patient pt : p){
            if(pt.getName().equalsIgnoreCase(name)){
                System.out.println(pt);
                return;
            }
        }
        System.out.println("*No entry exists for this patient..!");
    }

    public void viewPatients(){
        if(p.isEmpty()){
            System.out.println("*No patients for Now..!");
            return;
        }

        for(Patient pt : p){
            System.out.println(pt);
        }
    }
}

class PatientPriorityComparator implements Comparator<Patient>{
    public int compare(Patient p1 , Patient p2){
        if(p1.getPriority() == p2.getPriority()) return 0;
        else if (p1.getPriority() > p2.getPriority()) {
            return -1;
        }else return 1;
    }
}

public class PatientManagementLogic {
    public static void main(String[] args) {
        System.out.println("Main Method...");
    }
}
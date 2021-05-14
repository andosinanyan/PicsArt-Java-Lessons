package ObjectsAndServices;

 class UtilityMoto extends Moto{

    private String jobFunctionality;

     UtilityMoto(String name, int seatsCount, boolean passenger, int wheelCount, String owner) {
        super(name, seatsCount, passenger, wheelCount, owner);
    }

     String getJobFunctionality() {
        return jobFunctionality;
    }

     void setJobFunctionality(String jobFunctionality) {
        this.jobFunctionality = jobFunctionality;
    }

    void doSpecifiedJob(){
        System.out.println("This moto is for this kind of jobs: " + this.jobFunctionality);
    }
}

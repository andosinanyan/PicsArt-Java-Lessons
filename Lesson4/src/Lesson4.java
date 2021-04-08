public class Lesson4 {
    public static void main(String[] args) {
        System.out.println("Bubble sort (analyze and implement bubble sort)");
        int[] array = {12,23,45,1,3,4};
        boolean isOkay = false;

        while(!isOkay){
            isOkay = true;
            for(int i = 0; i <array.length - 1; i++){
                if(array[i] > array[i + 1]){
                    int j = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = j;
                    isOkay = false;
                }
            }
        }

        System.out.println("Create Logical Structures (As big as possible) from your life and print them in main function.");
        Mobile iphone = new Mobile();
        iphone.setColor("black");
        iphone.setName("Iphone 10");
        iphone.setSmartPhone(true);
        iphone.setPriceWithDollars(1500);
        Mobile samsung = new Mobile();
        samsung.setColor("gray");
        samsung.setName("Samsung S20");
        samsung.setSmartPhone(true);
        samsung.setPriceWithDollars(950);

        System.out.println("If you want you can buy this phones\n  1. " + iphone.getColor() + " " + iphone.getName() + " with " +
                 + iphone.getPriceWithDollars() + " dollars" );
        System.out.println("  2. " + samsung.getColor() + " " + samsung.getName() + " with " + samsung.getPriceWithDollars() + " dollars\n");

        System.out.println("\nNow we can use one of the phone's calculator \nLet's add two numbers 15 + 20 = " + samsung.Calculator(15,20,'+'));
        System.out.println("\nOr let's try this one 15 * 30 = " + samsung.Calculator(15,30,'*'));
        System.out.println("\nOr let's try this one 15 / 5 = " + samsung.Calculator(15,5,'/'));
        System.out.println("\nOr let's try this one 15 - 5 = " + samsung.Calculator(15,5,'-'));
    }
}

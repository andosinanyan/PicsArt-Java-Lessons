package Lesson2;

public class Lesson2 {
    public static void main(String[] args) {
        int[] arrayOddNums = {1,3,5,7,9};
        int[] arrayEvenNums = {2,4,6,8,10};

        System.out.println("here we add the first elements of the both arrays"+ " " + (arrayOddNums[0] + arrayEvenNums[0]));
        System.out.println("multiplication"+ " " + (arrayEvenNums[1] * arrayOddNums[1]));
        System.out.println("division"+ " " + (arrayEvenNums[2] / arrayOddNums[2]));
        System.out.println("We are going to add the lengths of array and then understand the result is odd or even" + " " +
                (arrayEvenNums.length + arrayOddNums.length) + " " + "and the result is"+ " " + ((arrayEvenNums.length + arrayOddNums.length) % 2 != 0 ?" odd":" even"));
        System.out.println("and the increment, decrement"+ " " + (arrayEvenNums[3]-- + ++arrayOddNums[3]));//arrayOddNums[3] = 9 ,(7 + 9) , arrayEvenNums[3] = 6


        int a = 15;
        a ^= 5;
        System.out.println("here we are using XOR which changes the same bits to 0 and different bits to 1" + " " + a);
        a <<= 2;
        System.out.println("than we are shifting the two bits left"+ " " + a);

        if(a > 0)
            System.out.println("a is positive");
        else
            System.out.println("a is negative ");
    }
}

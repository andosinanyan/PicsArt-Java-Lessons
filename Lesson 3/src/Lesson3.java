public class Lesson3 {
    public static void main(String[] args) {
        System.out.println("Task 1. \n Create an array and fill it with 2 number.\n");
           int arrayFirst[] = {0,1};
        System.out.println("Task 2. \n Create an array and fill it with numbers from 1:1000.\n");
            int[] arraySecond = new int[1000];
            for(int i = 1; i <= 1000; i++){
                arraySecond[i-1] = i;
            }
        System.out.println("Task 3. \n Create an array and fill it with odd numbers from -20:20");
            int[] arrayOddNums = new int[20];
            // the first version
            for(int i = -19, j = 0; i <20; i+=2, j++){
                arrayOddNums[j] = i;
            }
            //the second version
            int[] arrayOddNums2 = new int[20];
            int j = 0;
            for(int i = -20; i < 20; i++) {
                if (i % 2 != 0) {
                    arrayOddNums2[j] = i;
                    j++;
                }
            }
        System.out.println("Task 4. \n Create an array and fill it. Print all elements which can be divided by 5.\n");
            int[] arrayForFives = {10,1,5,3,18,34,15,60,87,90,0};
            for(int i = 0; i <arrayForFives.length; i++ ){
                if(arrayForFives[i] % 5 ==0)
                    System.out.printf("%d    can be divided by 5\n", arrayForFives[i]);
            }
        System.out.println("\n Task 5. \n Create an array and fill it. Print all elements which are between 24.12 and 467.23.\n");
            float[] arrayOfFloats = {15.56f,45.69f,98f,467.1f, 19.61f};
            for(int i = 0; i < arrayOfFloats.length; i++)
                if(arrayOfFloats[i] > 24.12f && arrayOfFloats[i] < 467.23f)
                    System.out.printf("%f\n",arrayOfFloats[i]);
        System.out.println("\n Task 6. \n Create an array and fill it. Print count of elements which can be divided by 2.\n");
            int[] arrayForTwo = {15, 48, 1698, 0, 32, -4, -3, -1, 1};
            int counter = 0;
            for(int i = 0; i < arrayForTwo.length; i++){
                if(arrayForTwo[i] % 2 == 0)
                    counter++;
            }
        System.out.printf("the count of the numbers that can be divided by 2 is %d\n",counter);
        System.out.println("\n Task 7.  \n Given an integer, 0< N < 21 , print its first 10 multiples. \n" +
                "Each multiple  N x i (where 0<i<11) should be printed on a new line in the form: N x i = result\n");
        int n = 18;
        if(n > 0 && n < 21)
        for(int i = 1; i <= 10; i++)
            System.out.println(n + " x " + i + " = " + (n * i));
        else
            System.out.println("the number must be 0 < N < 21");
    }
}

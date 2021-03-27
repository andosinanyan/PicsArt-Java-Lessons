public class Lesson1 {
    public static void main(String[] args) {
        byte byteVariable = 126;
        int integerVariable = 180;
        short shortVariable = 32766;
        long longVariable = 9796150800004L;
        float floatVariable = 1872.914f;
        double doubleVariable = 187841;
        boolean booleanVariable = true;
        char charVariable = 'A';
        String stringVariable = "This is String Variable";
        char space = (char)32;

        System.out.println(stringVariable + space + byteVariable + space + integerVariable +
                space + shortVariable + space + charVariable + space + longVariable + space
                + floatVariable + space + doubleVariable + space + booleanVariable);
    }
}
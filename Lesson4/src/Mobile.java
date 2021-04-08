public class Mobile {
    private String name;
    private String color;
    private boolean isSmartPhone;
    private int priceWithDollars;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public boolean isSmartPhone() {
        return isSmartPhone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSmartPhone(boolean smartPhone) {
        isSmartPhone = smartPhone;
    }

    public int getPriceWithDollars() {
        return priceWithDollars;
    }

    public void setPriceWithDollars(int priceWithDollars) {
        this.priceWithDollars = priceWithDollars;
    }

    public int Calculator(int num1, int num2, char action){
        switch (action){
            case '*':
                    return (num1 * num2);
            case '+':
                    return (num1 + num2);
            case '-':
                return (num1 - num2);
            case '/':
                return (num1/num2);
            default:
                return 0;
        }
    }
}

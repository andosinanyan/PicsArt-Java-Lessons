package ObjectsAndServices;

class User {
    private String login;
    private String password;
    private String name;
    private int finance;
    private boolean seller;

    User(String login, String password, String name, int finance, boolean seller) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.finance = finance;
        this.seller = seller;
    }

     String getLogin() {
        return login;
    }

     String getPassword() {
        return password;
    }

     String getName() {
        return name;
    }

     int getFinance() {
        return finance;
    }

    boolean isSeller() {
        return seller;
    }

    static User login(){
        return UserService.loginUser();
    }
}

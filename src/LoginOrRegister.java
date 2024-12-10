import java.util.Scanner;

public class LoginOrRegister implements Welcome {
    Scanner scn = new Scanner(System.in);
    private String username;

    public void registerOrLogin() {
        SqlQuery sqlq = new SqlQuery();
        User user = new User();
        Scanner sc = new Scanner(System.in);
        welcomeText();
        int choose = scn.nextInt();
        int loginStatus = 0;

        switch (choose) {
            case 1:
                System.out.println("Podaj login:");
                user.setLogin(sc.next());
                System.out.println("Podaj hasło:");
                user.setPassword(sc.next());

                user.setRole(sqlq.login(user.getLogin(), user.getPassword()));

                if(!user.getRole().equals("false")) {
                    System.out.println("Jesteś zalogowany");
                    loginStatus=1;
                }
                else {
                    System.out.println("Nie udało się zalogować");
                }
                break;
            case 2:
                System.out.println("Podaj login:");
                user.setLogin(sc.next());
                System.out.println("Podaj hasło:");
                user.setPassword(sc.next());

                if(sqlq.register(user.getLogin(), user.getPassword())) {
                    System.out.println("Konto zostało utworzone");
                }
                else {
                    System.out.println("Nie można utworzyć konta");
                }
                break;
        }
    }

    public String getUsername() {
        return username;
    }

    @Override
    public void welcomeText() {
        System.out.println("WELCOME TO THE SYSTEM! PLEASE CHOOSE 1 - LOGIN OR 2 - REGISTER");
    }
}
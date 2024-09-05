package extend_lesson.giuakhoa.services;
import extend_lesson.giuakhoa.entities.User;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;
public class Register {

    private UserService userService;
    private Scanner scanner;
    public Register(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }
    public void execute(){
        do{


            System.out.println("nhập username:");
            String username = scanner.nextLine();
            System.out.println("nhập email:");
            String email = scanner.nextLine();
            System.out.println("nhập password:");
            String password = scanner.nextLine();
            if (userService.register(username,email,password)){
                System.out.println("đăng kí thành công.");
                break;
            }
            else{
                System.out.println("Đăng kí thất bại. Username hoặc email đã tồn tại hoặc không hợp lệ.");
            }
        }while (true);
    }
}







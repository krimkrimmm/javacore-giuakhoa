package extend_lesson.giuakhoa.services;
import extend_lesson.giuakhoa.entities.User;
import java.util.List;
import java.util.Scanner;

public class LogIn {

    private UserService userService;
    private Scanner scanner;

    public LogIn(UserService userService, Scanner scanner) {
        this.userService = userService;
        this.scanner = scanner;
    }
    public void execute(){
        System.out.println("nhập email:");

        String email = scanner.nextLine();
        System.out.println("nhập mật khẩu mới:");
        String newPassword = scanner.nextLine();
        if (userService.resetPassword(email,newPassword)){
            System.out.println("đổi mật khẩu thành công. Vui lòng đăng nhập lại.");

        }else{
            System.out.println("Email không tồn tại tài khoản hoặc mật khẩu không hợp lệ.");
        }

    }
}


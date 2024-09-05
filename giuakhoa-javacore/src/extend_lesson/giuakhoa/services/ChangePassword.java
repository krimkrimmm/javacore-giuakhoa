package extend_lesson.giuakhoa.services;
import extend_lesson.giuakhoa.entities.User;

import java.util.Scanner;
public class ChangePassword {
    private UserService userService;

    private Scanner scanner;
    private User user;

    public ChangePassword(UserService userService, Scanner scanner, User user) {
        this.userService = userService;
        this.scanner = scanner;
        this.user = user;
    }
    public void execute(){

        System.out.println("nhập mật khu mới:");
        String newPassword = scanner.nextLine();
        if (userService.changePassword(user.getUsername(),newPassword)){
            System.out.println("Đổi mật khẩu thành công.");
        }else{
            System.out.println("mật khẩu không hợp lệ.");
        }
    }
}



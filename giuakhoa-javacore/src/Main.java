//Viết chương trình thực hiện:
//Khi mới bắt đầu chương trình, người dùng có các lựa chọn:
//1 - Đăng nhập
//2 - Đăng ký

//Đăng nhập

//Để đăng nhập, cần sử dụng username và password.
//Nếu nhập sai username thì thông báo “Kiểm tra lại username” và cho đăng nhập lại, nhập sai password thì hiện yêu cầu:
//1 - Đăng nhập lại
//2 - Quên mật khẩu
//
//Sau khi đăng nhập thành công, hiển thị “Chào mừng <Tên user>, bạn có thể thực hiện các công việc sau:”
//1 - Thay đổi username
//2 - Thay đổi email
//3 - Thay đổi mật khẩu
//4 - Đăng xuất (Sau khi đăng xuất quay về mục yêu cầu đăng nhập hoặc đăng ký)
//0 - Thoát chương trình
//
//Lưu ý: username và email mới phải chưa tồn tại
//
//Quên mật khẩu
//Tại mục quên mật khẩu thì có nhập email.
//Nếu email đúng thì cho phép đổi mật khẩu và tiến hành đăng nhập.
//Nếu email sai thì báo chưa tồn tại tài khoản
//Tạo tài khoản mới

//Để tạo tài khoản mới cần nhập username, email, password. Trong đó:
//username phải chưa tồn tại
//email phải chuẩn (Sử dụng regex), chưa tồn tại trong List
//password dài từ 7 đến 15 ký tự, chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt (. , - _ ;)
//pvi bai ktra: do while, arraylist, chia tách ham

import extend_lesson.giuakhoa.entities.User;
import extend_lesson.giuakhoa.services.LogIn;
import extend_lesson.giuakhoa.services.Register;
import extend_lesson.giuakhoa.services.ChangePassword;
import extend_lesson.giuakhoa.services.ChangeEmail;
import extend_lesson.giuakhoa.services.ChangeUsername;
import extend_lesson.giuakhoa.services.Exit;
import extend_lesson.giuakhoa.services.LogOut;
import extend_lesson.giuakhoa.services.ForgotPassword;
import extend_lesson.giuakhoa.services.LogBackIn;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<User> users = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static User user = null;
    public static void main(String[] args) {
        do {
            if (user == null) {
                System.out.println("1 - Đăng nhập");
                System.out.println("2 - Đăng ký");
                System.out.println("0 - Thoát chương trình");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        user = new LogIn(users, scanner).execute();
                        break;
                    case 2:
                        new Register(users, scanner).execute();
                        break;
                    case 0:
                        new Exit().execute();
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }
            } else {
                System.out.println("1 - Thay đổi username");
                System.out.println("2 - Thay đổi email");
                System.out.println("3 - Thay đổi mật khẩu");
                System.out.println("4 - Đăng xuất");
                System.out.println("0 - Thoát chương trình");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        new ChangeUsername(users, scanner).execute(user);
                        break;
                    case 2:
                        new ChangeEmail(users, scanner).execute(user);
                        break;
                    case 3:
                        new ChangePassword(scanner).execute(user);
                        break;
                    case 4:
                        new LogOut().execute();
                        user = null;
                        break;
                    case 0:
                        new Exit().execute();
                        break;

                        default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }
            }
        } while (true);
    }
}

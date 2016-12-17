package security.dto;

import org.hibernate.validator.constraints.NotEmpty;
import security.util.PasswordMatches;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@PasswordMatches
public class UserTO{

    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9]{4,}$",
            message = "имя пользователя должно быть длиннее 4 символов и состоять из цифр и букв английского алфавита")
    private String login;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "(?=^.{8,}$)(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?!.*\\W).*$",
            message = "пароль недостаточно сложен: должны быть цифры, заглавные и строчные буквы и длинна минимум 8 символов")
    private String password;
    private String matchingPassword;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    @Override
    public String toString() {
        return "UserTO{" +
                "password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}

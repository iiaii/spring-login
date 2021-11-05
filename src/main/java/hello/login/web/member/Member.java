package hello.login.web.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Member {

    private Long id;

    @NotEmpty
    private String loginId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String password;

    public boolean isEqualPassword(final String password) {
        return password.equals(this.password);
    }

    public boolean isEqualId(final String loginId) {
        return loginId.equals(this.loginId);
    }
}

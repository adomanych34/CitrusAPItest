package models.usermodels;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserModels {
    private String email;
    private String name;
    private String phone;
    private String password;
    private String confirm_password;
}

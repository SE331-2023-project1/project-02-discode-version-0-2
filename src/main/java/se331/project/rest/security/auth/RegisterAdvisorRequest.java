package se331.project.rest.security.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterAdvisorRequest {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
}

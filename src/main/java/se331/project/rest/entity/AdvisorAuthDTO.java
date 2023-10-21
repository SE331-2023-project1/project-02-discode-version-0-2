package se331.project.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.project.rest.security.user.Role;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvisorAuthDTO {
    Long id;
    String name;
    List<Role> roles = new ArrayList<>();
}

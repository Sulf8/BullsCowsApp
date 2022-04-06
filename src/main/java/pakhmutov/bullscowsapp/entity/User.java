package pakhmutov.bullscowsapp.entity;

import lombok.*;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * сущность пользователей
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity (name = "Users")
public class User {
    @NotEmpty (message = "Name should not be empty")
    @Id
    private String username;

    @NotEmpty (message = "Password should not be empty")
    @Size (min=3, max=7, message = "Name should be between 3 and 7 characters")
    private String password;

}

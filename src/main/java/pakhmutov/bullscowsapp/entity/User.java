package pakhmutov.bullscowsapp.entity;

import lombok.*;
import org.hibernate.annotations.Table;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * сущность пользователей
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(appliesTo = "Users")
public class User {
    @NotEmpty (message = "Name should not be empty")
    @Id
    private String username;

    @NotEmpty (message = "Password should not be empty")
    @Size (min=3, max=5, message = "Name should be between 3 and 5 characters")
    private String password;

}

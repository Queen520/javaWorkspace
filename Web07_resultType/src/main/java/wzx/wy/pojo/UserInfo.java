package wzx.wy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {
    private Integer userId;
    private String username;
    private String userSex;
    private String userBirthday;
    private String userAddress;
}

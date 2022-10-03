package cn.tedu.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer uid;
    private String uname;
    private String password;
    private String nickName;
    private String images;
    private String stat;
    private String createTime;
    private String modifyTime;
    private Integer deleted;
    private String role;
}

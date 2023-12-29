package cn.zyy.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {

    private Long id;
    private String name;
    private String pwd;
    private String mobile;
    private String email;
    /**
     * 性别
     */
    private Integer gender;

}

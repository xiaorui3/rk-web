package com.xiaorui.pojo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(description = "用户的实体类")
public class User {
    @Schema(description = "用户的实体类----ID")
    private int id;
    @Schema(description = "用户的实体类----名字")
    private int age;
    @Schema(description = "用户的实体类----密码")
    private String name;

}

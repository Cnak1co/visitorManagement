package com.study.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("users")
public class User implements Serializable {

    @TableId(type=IdType.AUTO)
    private Integer UID;

    @TableField(value = "UName")
    private String uName;

    @TableField(value = "UPwd")
    private String uPwd;

    @TableField(value = "URealName")
    private String uRealName;

    @TableField(value = "URole")
    private String uRole;
}

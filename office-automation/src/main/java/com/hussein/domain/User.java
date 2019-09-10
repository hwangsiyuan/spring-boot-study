package com.hussein.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * <p>Title: User</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/7 2:43 PM
 */
@Getter
@Setter
@Entity
@Table(name = "tb_oa_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id", length = 50)
    private String userId;

    /**
     * 姓名
     */
    @Column(name = "name", length = 128)
    private String name;

    /**
     * 密码
     */
    @Column(name = "password", length = 128)
    private String password;

    /**
     * 性别 1:男;2:女
     */
    @Column(name = "sex", length = 1)
    private Short sex;

    /**
     * 邮箱
     */
    @Column(name = "email", length = 128)
    private String email;

    /**
     * 手机号
     */
    @Column(name = "telephone", length = 20)
    private String telephone;

    /**
     * qq号
     */
    @Column(name = "qq_num", length = 20)
    private String qqNum;

    /**
     * 问题编号
     */
    @Column(name = "question_num", length = 1)
    private Short questionNum;

    /**
     * 问题答案
     */
    @Column(name = "answer", length = 200)
    private String answer;

    /**
     * 状态 0新建;1审核;2审核不通过;3冻结
     */
    @Column(name = "status", length = 1)
    private Short status;

    /**
     * 创建人
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "creator", referencedColumnName = "user_id", foreignKey = @ForeignKey(name = "fk_oa_user_creator"))
    private User creator;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;


    /**
     * 修改人
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "modifier", referencedColumnName = "user_id", foreignKey = @ForeignKey(name = "fk_oa_user_modifier"))
    private User modifier;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyTime;

    /**
     * 修改人
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "check_user", referencedColumnName = "user_id", foreignKey = @ForeignKey(name = "fk_oa_user_check_user"))
    private User checkUser;

    /**
     * 审核时间
     */
    @Column(name = "check_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkTime;

    /**
     * 部门
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Dept.class)
    @JoinColumn(name = "dept_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_oa_user_dept"))
    private Dept dept;

    /**
     * 职位
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Job.class)
    @JoinColumn(name = "job_code", referencedColumnName = "code", foreignKey = @ForeignKey(name = "fk_oa_user_job"))
    private Job job;

    /**
     * 用户角色
     */
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Role.class, mappedBy = "users")
    private Set<Role> roles = new HashSet<>();

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name);
    }
}

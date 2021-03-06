package com.hussein.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * <p>Title: Popedom</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy popedom
 * @date 2019/9/7 4:30 PM
 */
@Getter
@Setter
@Entity
@Table(name = "tb_oa_popedom")
public class Popedom implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 权限模块
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Module.class)
    @JoinColumn(name = "module_code", referencedColumnName = "code", foreignKey = @ForeignKey(name = "fk_oa_popedom_module"))
    private Module module;

    /**
     * 权限操作
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Module.class)
    @JoinColumn(name = "operate_code", referencedColumnName = "code", foreignKey = @ForeignKey(name = "fk_oa_popedom_operate"))
    private Module operate;

    /**
     * 角色
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Role.class)
    @JoinColumn(name = "role_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_oa_popedom_role"))
    private Role role;

    /**
     * 创建人
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "creator", referencedColumnName = "user_id", foreignKey = @ForeignKey(name = "fk_oa_popedom_creator"))
    private User creator;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @Override
    public String toString() {
        return "Popedom{" +
                "id=" + id +
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
        Popedom popedom = (Popedom) o;
        return Objects.equals(id, popedom.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

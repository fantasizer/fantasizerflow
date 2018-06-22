package org.fantasizer.domain;

import javax.persistence.*;

/**
 * 部门信息
 *
 * @author quxiaoyong 2018/6/22 17:36
 */
@Entity
@Table(name = "sys_department_info")
public class Department extends AbstractAuditingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 排序
     */
    @Column(name = "order_id", length = 10)
    private Integer orderId;
    /**
     * 父部门id
     */
    @Column(name = "parent_id")
    private Integer parentId;
    /**
     * 父级ids
     */
    @Column(name = "parent_ids", length = 255)
    private String pids;
    /**
     * 简称
     */
    @Column(name = "simple_name", length = 50)
    private String simpleName;
    /**
     * 全称
     */
    @Column(name = "full_name", length = 50)
    private String fullName;
    /**
     * 提示
     */
    @Column(name = "tips", length = 200)
    private String tips;
    /**
     * 版本（乐观锁保留字段）
     */
    @Column(name = "version", length = 10)
    private Integer version;

}

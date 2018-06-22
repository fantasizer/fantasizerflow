package org.fantasizer.repository;

import org.fantasizer.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author quxiaoyong 2018/6/22 17:44
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findOneById(Long id);

    List<Department> findDepartmentsBySimpleName(String simpleName);

}

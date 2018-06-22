package org.fantasizer.service;

import org.fantasizer.domain.Department;
import org.fantasizer.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author quxiaoyong 2018/6/22 17:47
 */
@Service
@Transactional
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department queryDepartment(Long id) {
        return this.departmentRepository.findOneById(id);
    }

}

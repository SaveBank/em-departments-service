package SaveBankDepartmentService.Repository;

import SaveBankDepartmentService.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {


    Department findByDepartmentCode(String departmentCode);
}

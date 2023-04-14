package SaveBankDepartmentService.Service;

import SaveBankDepartmentService.Dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String departmentCode);
}

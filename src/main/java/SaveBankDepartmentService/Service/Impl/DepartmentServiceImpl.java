package SaveBankDepartmentService.Service.Impl;

import SaveBankDepartmentService.Dto.DepartmentDto;
import SaveBankDepartmentService.Entity.Department;
import SaveBankDepartmentService.Mapper.DepartmentDtoMapper;
import SaveBankDepartmentService.Repository.DepartmentRepository;
import SaveBankDepartmentService.Service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // convert department dto to department jpa entity
        Department department = DepartmentDtoMapper.mapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentDtoMapper.mapper.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = DepartmentDtoMapper.mapper.mapToDepartmentDto(department);

        return departmentDto;
    }
}

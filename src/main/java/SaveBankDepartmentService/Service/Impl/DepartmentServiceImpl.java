package SaveBankDepartmentService.Service.Impl;

import SaveBankDepartmentService.Dto.DepartmentDto;
import SaveBankDepartmentService.Entity.Department;
import SaveBankDepartmentService.Exception.DepartmentCodeAlreadyExistsException;
import SaveBankDepartmentService.Exception.ResourceNotFoundException;
import SaveBankDepartmentService.Mapper.DepartmentDtoMapper;
import SaveBankDepartmentService.Repository.DepartmentRepository;
import SaveBankDepartmentService.Service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Optional<Department> departmentExist = departmentRepository.findByDepartmentCode(departmentDto.getDepartmentCode());
        if (departmentExist.isPresent()){
            throw new DepartmentCodeAlreadyExistsException("Department code already exist");
        }

        // convert department dto to department jpa entity
        Department department = DepartmentDtoMapper.mapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentDtoMapper.mapper.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode).orElseThrow(
                () -> new ResourceNotFoundException("Department","departmentCode", departmentCode)
        );

        DepartmentDto departmentDto = DepartmentDtoMapper.mapper.mapToDepartmentDto(department);

        return departmentDto;
    }
}

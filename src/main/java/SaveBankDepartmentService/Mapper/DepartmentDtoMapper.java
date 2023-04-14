package SaveBankDepartmentService.Mapper;

import SaveBankDepartmentService.Dto.DepartmentDto;
import SaveBankDepartmentService.Entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DepartmentDtoMapper {

    DepartmentDtoMapper mapper = Mappers.getMapper(DepartmentDtoMapper.class);

    Department mapToDepartment(DepartmentDto departmentDto);
    DepartmentDto mapToDepartmentDto(Department user);
    List<DepartmentDto> mapListToDepartmentDto(List<Department> userList);
}

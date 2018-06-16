package skhu.artview.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.Project;

@Mapper
public interface ProjectMapper {
	Project findOne(int id);
	List<Project> findByTitle(String title);
    List<Project> findAll();
    void insert(Project project);
    void delete(int id);
}

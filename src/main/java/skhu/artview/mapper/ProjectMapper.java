package skhu.artview.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.Project;

@Mapper
public interface ProjectMapper {
	Project findOne(int id);
    List<Project> findAll();
    List<Project> findByUserName(String keyword);
    List<Project> findByTitle(String keyword);
    List<Project> findByContent(String keyword);
    List<Project> findByTitleAndContent(String keyword);
    void insert(Project project);
    void delete(int id);
}

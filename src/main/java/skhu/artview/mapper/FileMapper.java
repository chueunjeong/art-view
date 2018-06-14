package skhu.artview.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.FileDTO;

@Mapper
public interface FileMapper {
	FileDTO findOne(int id);
	List<FileDTO> findAll();
	void insert(FileDTO file);
	void update(FileDTO file);
	void delete(int id);
	String getName(int id);
}
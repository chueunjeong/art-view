package skhu.artview.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import skhu.artview.dto.Contract;

@Mapper
public interface ContractMapper {
	Contract findOne(int id);
	List<Contract> findByGroupidId(int groupig_id );
    List<Contract> findByPexhibitionId(int pexhibition_id);
    List<Contract> findBySpaceId(int space_id);
   
	List<Contract> findAll();
	
	void updateSpace_id(int id);
	void updateProvider_id(int id);
	void updateCost(int id);
	void delete(int id);
	void insert(Contract contract);
}

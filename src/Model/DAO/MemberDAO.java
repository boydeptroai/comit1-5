package Model.DAO;

import java.util.List;

import Entity.KanjiTopic;
import Entity.KanjiWordNewsEntity;
import Entity.MemberEntity;

public interface MemberDAO extends BaseDAO<MemberEntity>{
	MemberEntity findOne(Integer id);
	//List<KanjiTopic> findByCategoryId(Long categoryId);
	Integer save(MemberEntity memDetail);
	void update(MemberEntity memDetail);
	void delete(Integer id);
	List<MemberEntity> findAll( Integer offset,Integer limit);
	int getTotalItem();

}

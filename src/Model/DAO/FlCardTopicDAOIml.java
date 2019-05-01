package Model.DAO;

import java.util.List;

import Entity.FlCardTopicEntity;
import Entity.KanjiTopic;
import Model.Mapper.FlCardTopicMapper;
import Model.Mapper.FlashCardMapper;
import Model.DBConnection;

public class FlCardTopicDAOIml extends BaseDAOIml<FlCardTopicEntity>implements FlCardTopicDAO{

	

	@Override
	public FlCardTopicEntity findOne(Integer id) {
		String sql = "SELECT * FROM tbl_flctopic WHERE flctopic_id = ?";
		List<FlCardTopicEntity> result = Query(sql, new FlCardTopicMapper(), id);
		return result.isEmpty() ? null : result.get(0);
	}

	@Override
	public Integer save(FlCardTopicEntity FlTopicDetail) {
		String sql="insert into tbl_flctopic(flctopic_name,flctopic_img) values(?,?)";
		return Insert(sql,FlTopicDetail.getFlctopic_name(),FlTopicDetail.getFlctopic_img() );
	}

	@Override
	public void update(FlCardTopicEntity FlTopicDetail) {
		// TODO Auto-generated method stub
		String sql="UPDATE tbl_flctopic SET flctopic_name=?,flctopic_img=? where flctopic_id=?";		
		 Update(sql,FlTopicDetail.getFlctopic_name(),FlTopicDetail.getFlctopic_img() ,FlTopicDetail.getFlctopic_id());
		
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM tbl_flctopic WHERE flctopic_id = ?";
		Delete(sql, id);
		
	}
	public static void main(String[] args) {
		FlCardTopicEntity fl=new FlCardTopicEntity();
		FlCardTopicDAOIml f=new FlCardTopicDAOIml();
		fl.setFlctopic_img("a");
		fl.setFlctopic_name("n");
		fl.setFlctopic_id(7);
		System.out.println();
		f.update(fl);
		
	}

	@Override
	public List<FlCardTopicEntity> findAll(Integer offset, Integer limit) {
		String sql = "SELECT * FROM tbl_flctopic ORDER BY flctopic_id DESC LIMIT ?, ? ";
		return Query(sql, new FlCardTopicMapper(), offset,limit);
	}

	@Override
	public int getTotalItem() {
		String sql="SELECT count(*) from tbl_flctopic";
		return Count(sql);
	}

}

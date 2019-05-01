package Model.DAO;

import java.util.List;

import Entity.CommentEntity;
import Entity.KanjiTopic;
import Model.Mapper.CommentMapper;

import Model.DBConnection;

public class CmtDAOIml extends BaseDAOIml<CommentEntity> implements CmtDAO{

	

	@Override
	public CommentEntity findOne(Integer id) {
		String sql = "SELECT * FROM tbl_cmt WHERE cmt_id = ?";
		List<CommentEntity> result = Query(sql, new CommentMapper(), id);
		return result.isEmpty() ? null : result.get(0);
	}

	@Override
	public Integer save(CommentEntity cmtDetail) {
		String sql="insert into tbl_cmt(cmt_content,word_id,member_id,cmt_time) values(?,?,?,?)";
		return Insert(sql, cmtDetail.getCmt_content(),cmtDetail.getWord_id(),cmtDetail.getMember_id(),cmtDetail.getCmt_time());
	}
	

	@Override
	public void update(CommentEntity cmtDetail) {
		// TODO Auto-generated method stub
		//System.out.println("koko");
				String sql="UPDATE tbl_cmt SET cmt_content=?,word_id=?,member_id=?,cmt_time=? where cmt_id=?";		
				 Update(sql, cmtDetail.getCmt_content(),cmtDetail.getWord_id(),cmtDetail.getMember_id(),cmtDetail.getCmt_time(),cmtDetail.getCmt_id());
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tbl_cmt WHERE cmt_id = ?";
		Delete(sql, id);
		
	}
	public static void main(String[] args) {
		CommentEntity m=new CommentEntity();
		m.setCmt_content("a");
		m.setMember_id(1);
		m.setWord_id(1);
		
	}

}

package Model.DAO;

import java.util.List;

import Entity.KanjiWordNewsEntity;
import Entity.MemberEntity;
import Model.Mapper.KanjiNewsMapper;
import Model.Mapper.MemberMapper;
import Model.DBConnection;

public class MemberDAOIml extends BaseDAOIml<MemberEntity> implements MemberDAO{

	

	@Override
	public MemberEntity findOne(Integer id) {
		String sql = "SELECT * FROM tbl_member WHERE member_id = ?";
		List<MemberEntity> result = Query(sql, new MemberMapper(), id);
		return result.isEmpty() ? null : result.get(0);
	}

	@Override
	public Integer save(MemberEntity memDetail) {
		String sql="insert into tbl_member(member_firstname,member_lastname,member_email,member_pass,member_img,category_id,member_status) values(?,?,?,?,?,?,?)";
		return Insert(sql,memDetail.getMember_firstname(),memDetail.getMember_lastname(),memDetail.getMember_email(),memDetail.getMember_pass(),memDetail.getMember_img(),memDetail.getCategory_id(),memDetail.getMember_status() );
	}

	@Override
	public void update(MemberEntity memDetail) {
		StringBuilder sql = new StringBuilder("UPDATE tbl_member SET member_firstname=?,member_lastname=?,");
		sql.append(" member_email=?,member_pass=?,member_img=?,category_id=?,member_status  where member_id=?");
		 Update(sql.toString(),memDetail.getMember_firstname(),memDetail.getMember_lastname(),memDetail.getMember_email(),memDetail.getMember_pass(),memDetail.getMember_img(),memDetail.getCategory_id(),memDetail.getMember_status(),memDetail.getMember_id());


		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tbl_member WHERE member_id = ?";
		Delete(sql, id);
		
	}

	@Override
	public List<MemberEntity> findAll(Integer offset, Integer limit) {
		String sql = "SELECT * FROM tbl_member ORDER BY member_id DESC LIMIT ?, ? ";
		return Query(sql, new MemberMapper(), offset,limit);
	}

	@Override
	public int getTotalItem() {
		String sql="SELECT count(*) from tbl_member";
		return Count(sql);
	}

}

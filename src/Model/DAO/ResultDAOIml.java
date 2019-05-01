package Model.DAO;

import java.util.List;

import Entity.NoteEntity;
import Entity.ResultEntity;

import Model.Mapper.ResultMapper;
import Model.DBConnection;

public class ResultDAOIml extends BaseDAOIml<ResultEntity>implements ResultDAO{

	

	@Override
	public ResultEntity findOne(Integer id) {
		String sql = "SELECT * FROM tbl_result WHERE result_id = ?";
		List<ResultEntity> result = Query(sql,new ResultMapper(), id);
		return result.isEmpty() ? null : result.get(0);
	}

	@Override
	public Integer save(ResultEntity rsDetail) {
		String sql="insert into tbl_result(result,time,test_id,member_id) values(?,?,?,?)";
		return Insert(sql,rsDetail.getResult(),rsDetail.getTime(),rsDetail.getTest_id(),rsDetail.getMember_id());
	}
	

	@Override
	public void update(ResultEntity rsDetail) {
		String sql="UPDATE tbl_result SET result=?,time=?,test_id=?,member_id=? where result_id=?";		
		 Update(sql,rsDetail.getResult(),rsDetail.getTime(),rsDetail.getTest_id(),rsDetail.getMember_id(),rsDetail.getResult_id());
		
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM tbl_result WHERE result_id = ?";
		Delete(sql, id);
		
	}

}

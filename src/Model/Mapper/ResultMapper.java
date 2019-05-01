package Model.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.ResultEntity;
import Entity.TestTopicEntity;

public class ResultMapper implements RowMapper<ResultEntity>{

	@Override
	public ResultEntity mapRow(ResultSet rs) {
		try {
			ResultEntity res=new ResultEntity();
			res.setTest_id(rs.getInt("test_id"));
			res.setResult_id(rs.getInt("result_id"));
			res.setMember_id(rs.getInt("member_id"));
			res.setTime(rs.getString("time"));
			res.setResult(rs.getString("result"));
			return res;
		} catch (SQLException e) {
			return null;
		}
	
	}

}

package Entity;

public class ResultEntity extends BaseEntity<ResultEntity>{
	private Integer result_id;
	private String result;
	private String time;
	private Integer test_id;
	private Integer member_id;

	public ResultEntity() {
		super();
	}

	public ResultEntity(Integer result_id, String result, String time, Integer test_id, Integer member_id) {
		super();
		this.result_id = result_id;
		this.result = result;
		this.time = time;
		this.test_id = test_id;
		this.member_id = member_id;
	}

	public Integer getResult_id() {
		return result_id;
	}

	public void setResult_id(Integer result_id) {
		this.result_id = result_id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getTest_id() {
		return test_id;
	}

	public void setTest_id(Integer test_id) {
		this.test_id = test_id;
	}

	public Integer getMember_id() {
		return member_id;
	}

	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
}

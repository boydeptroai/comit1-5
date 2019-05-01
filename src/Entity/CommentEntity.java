package Entity;

public class CommentEntity {
	private Integer cmt_id;
	private String cmt_content;
	private Integer word_id;
	private Integer member_id;
	private String cmt_time;

	public CommentEntity() {
		super();
	}

	public CommentEntity(Integer cmt_id, String cmt_content, Integer word_id, Integer member_id, String cmt_time) {
		super();
		this.cmt_id = cmt_id;
		this.cmt_content = cmt_content;
		this.word_id = word_id;
		this.member_id = member_id;
		this.cmt_time = cmt_time;
	}

	public Integer getCmt_id() {
		return cmt_id;
	}

	public void setCmt_id(Integer cmt_id) {
		this.cmt_id = cmt_id;
	}

	public String getCmt_content() {
		return cmt_content;
	}

	public void setCmt_content(String cmt_content) {
		this.cmt_content = cmt_content;
	}

	public Integer getWord_id() {
		return word_id;
	}

	public void setWord_id(Integer word_id) {
		this.word_id = word_id;
	}

	public Integer getMember_id() {
		return member_id;
	}

	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}

	public String getCmt_time() {
		return cmt_time;
	}

	public void setCmt_time(String cmt_time) {
		this.cmt_time = cmt_time;
	}

}

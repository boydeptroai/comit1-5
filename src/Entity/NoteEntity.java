package Entity;

public class NoteEntity extends BaseEntity<NoteEntity>{
	private Integer note_id;
	private String note_content;
	private Integer member_id;
	private Integer word_id;

	public NoteEntity() {
		super();
	}

	public NoteEntity(Integer note_id, String note_content, Integer member_id, Integer word_id) {
		super();
		this.note_id = note_id;
		this.note_content = note_content;
		this.member_id = member_id;
		this.word_id = word_id;
	}

	public Integer getNote_id() {
		return note_id;
	}

	public void setNote_id(Integer note_id) {
		this.note_id = note_id;
	}

	public String getNote_content() {
		return note_content;
	}

	public void setNote_content(String note_content) {
		this.note_content = note_content;
	}

	public Integer getMember_id() {
		return member_id;
	}

	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}

	public Integer getWord_id() {
		return word_id;
	}

	public void setWord_id(Integer word_id) {
		this.word_id = word_id;
	}
}

package cn.edu.xmut.MyContest.model;

public class Admin implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private String password;
	private String note;

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}

package cn.edu.xmut.MyContest.model;

public class Events implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String contestname;
	private String scope;
	private String organizer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContestname() {
		return contestname;
	}

	public void setContestname(String contestname) {
		this.contestname = contestname;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
}

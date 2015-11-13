package cn.edu.xmut.MyContest.model;

public class Apply implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String applyname;
	private String detail;
	private String plus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApplyname() {
		return applyname;
	}

	public void setApplyname(String applyname) {
		this.applyname = applyname;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public String getPlus() {
		return plus;
	}

	public void setPlus(String plus) {
		this.plus = plus;
	}	
}

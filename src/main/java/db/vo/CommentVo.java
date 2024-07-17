package db.vo;

public class CommentVo {

	int cmt_idx;
	int c_idx;
	int mem_idx;
	String mem_nickname;
	String cmt_content;
	String cmt_regdate;
	
	public CommentVo() {
		// TODO 자동 생성된 생성자 스텁
	}
	
	
	
	public CommentVo(int c_idx, int mem_idx, String mem_nickname, String cmt_content) {
		super();
		this.c_idx = c_idx;
		this.mem_idx = mem_idx;
		this.mem_nickname = mem_nickname;
		this.cmt_content = cmt_content;
	}


	public CommentVo(int cmt_idx, String cmt_content) {
		super();
		this.cmt_idx = cmt_idx;
		this.cmt_content = cmt_content;
	}



	public int getCmt_idx() {
		return cmt_idx;
	}
	public void setCmt_idx(int cmt_idx) {
		this.cmt_idx = cmt_idx;
	}
	public int getC_idx() {
		return c_idx;
	}
	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}
	public int getMem_idx() {
		return mem_idx;
	}
	public void setMem_idx(int mem_idx) {
		this.mem_idx = mem_idx;
	}
	public String getMem_nickname() {
		return mem_nickname;
	}
	public void setMem_nickname(String mem_nickname) {
		this.mem_nickname = mem_nickname;
	}
	public String getCmt_content() {
		return cmt_content;
	}
	public void setCmt_content(String cmt_content) {
		this.cmt_content = cmt_content;
	}
	public String getCmt_regdate() {
		return cmt_regdate;
	}
	public void setCmt_regdate(String cmt_regdate) {
		this.cmt_regdate = cmt_regdate;
	}
	
	
	
}

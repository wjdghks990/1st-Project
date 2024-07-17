package db.vo;

public class BoardVo {

	int 	c_idx;
	int		c_no;
	String  c_title;
	String  c_content;
	String 	c_regdate;
	String	c_category;
	int		c_inCount;
	String	c_reply;
	int 	mem_idx;
	String 	mem_nickname;
	
	public BoardVo() {
		// TODO Auto-generated constructor stub
	}
	


	public BoardVo(int c_inCount) {
		this.c_inCount = c_inCount;
	}


	public BoardVo(int c_idx, String c_title, String c_content) {
		super();
		this.c_idx = c_idx;
		this.c_title = c_title;
		this.c_content = c_content;
	}



	public BoardVo(String c_title, String c_content,String c_category, int mem_idx, String mem_nickname) {
		super();
		this.c_title = c_title;
		this.c_content = c_content;
		this.c_category= c_category;
		this.mem_idx = mem_idx;
		this.mem_nickname = mem_nickname;
	}

	
	public BoardVo(int c_no, String c_title, String c_content, String c_regdate, int mem_idx, String mem_nickname) {
		super();
		this.c_no = c_no;
		this.c_title = c_title;
		this.c_content = c_content;
		this.c_regdate = c_regdate;
		this.mem_idx = mem_idx;
		this.mem_nickname = mem_nickname;
	}

	
	
	public BoardVo(int c_idx , String c_title, String c_content, String c_category) {
		super();
		this.c_idx = c_idx;
		this.c_title = c_title;
		this.c_content = c_content;
		this.c_category = c_category;
	}



	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public int getC_idx() {
		return c_idx;
	}
	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}
	public String getC_title() {
		return c_title;
	}
	public void setC_title(String c_title) {
		this.c_title = c_title;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public String getC_regdate() {
		return c_regdate;
	}
	public void setC_regdate(String c_regdate) {
		this.c_regdate = c_regdate;
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

	public String getC_category() {
		return c_category;
	}

	public void setC_category(String c_category) {
		this.c_category = c_category;
	}

	public int getC_inCount() {
		return c_inCount;
	}

	public void setC_inCount(int c_inCount) {
		this.c_inCount = c_inCount;
	}

	public String getC_reply() {
		return c_reply;
	}

	public void setC_reply(String c_reply) {
		this.c_reply = c_reply;
	}
	
}

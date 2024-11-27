package dto;

import java.util.Date;

public class Member {

	private int mem_no;
	private String mem_id;
	private String mem_pass;
	private String mem_nick;
	private int mem_age;
	private String mem_phone;
	private String mem_addr;
	private String mem_job;
	private int mem_rank;
	private Date mem_hire;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	public Member(int mem_no, String mem_id, String mem_pass, String mem_nick, int mem_age, String mem_phone,
			String mem_addr, String mem_job, int mem_rank, Date mem_hire) {
		super();
		this.mem_no = mem_no;
		this.mem_id = mem_id;
		this.mem_pass = mem_pass;
		this.mem_nick = mem_nick;
		this.mem_age = mem_age;
		this.mem_phone = mem_phone;
		this.mem_addr = mem_addr;
		this.mem_job = mem_job;
		this.mem_rank = mem_rank;
		this.mem_hire = mem_hire;
	}

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public String getMem_id() {
		return mem_id;
	}
}
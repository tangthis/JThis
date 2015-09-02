/**
 * 
 */
package com.tang.po;

import java.util.Date;

/**
 * 
 * @author tangthis
 * <p>https://github.com/tangthis</p>
 *
 */
public class TestUser{
	private Long id;
	private String uname;
	private String phone;
	private Date birthday;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}

/**
 * 
 */
package com.tang.web.po.enums;


/**
 * 状态枚举类
 * @author tangthis
 * <p>https://github.com/tangthis</p>
 *
 */
public enum Status{
	NORMAL(0,"正常");
	private int type;
	private String text;
	
	private Status(int type,String text) {
		this.type = type;
		this.text = text;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public static Status getStatusByType(int type)
	{
		for(Status at:Status.values()){
			if(at.type==type){
				return at;
			}
		}
		throw new IllegalArgumentException("Not supported client type:" + type); 
	}
}

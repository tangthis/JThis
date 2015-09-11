package com.tang.web.vo;

import org.springframework.http.HttpStatus;
/**
 * 返回结果对象
 * @author tangthis
 * <p>https://github.com/tangthis</p>
 *
 */
public class Result {
	private boolean success = true;
	private Integer status = ResultStatus.OK.value();
	private Object data;
	private String msg = "";
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public Result() {
		super();
	}
	
	public Result(boolean success, Integer status, Object data, String msg) {
		super();
		this.success = success;
		this.status = status;
		this.data = data;
		this.msg = msg;
	}
	
	public Result(Integer status,Object data){
		if(status == HttpStatus.OK.value()){
			this.success = true;
		}else {
			this.success = false;
		}
		this.status = status;
		this.data = data;
	}
	
	
	
	
}

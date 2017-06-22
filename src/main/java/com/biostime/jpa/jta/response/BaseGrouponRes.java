package com.biostime.jpa.jta.response;

public class BaseGrouponRes<T> extends BaseRes{
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}

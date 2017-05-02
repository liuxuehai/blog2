package com.blog.model.base;

public class BasePage extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int draw;
	private int start;
	private int length;
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

}

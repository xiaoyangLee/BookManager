package com.lxy.bookmanager.model;
/**
 * ͼ�����ʵ��
 * @author xiaoyang
 *
 */
public class bookType {
	private int id; 		//ͼ����
	private String bookTypeName; //ͼ���������
	private String bookTypeDesc; //ͼ���������
	
	//���췽��
	public bookType(int id, String bookTypeName, String bookTypeDesc) {
		super();
		this.id = id;
		this.bookTypeName = bookTypeName;
		this.bookTypeDesc = bookTypeDesc;
	}
	
	public bookType() {
		super();
	}

	public bookType(String bookTypeName, String bookTypeDesc) {
		super();
		this.bookTypeName = bookTypeName;
		this.bookTypeDesc = bookTypeDesc;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getBookTypeDesc() {
		return bookTypeDesc;
	}
	public void setBookTypeDesc(String bookTypeDesc) {
		this.bookTypeDesc = bookTypeDesc;
	}

	@Override
	public String toString() {
		return bookTypeName;
	}
	
	
}

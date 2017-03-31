package com.lxy.bookmanager.model;
/**
 * ͼ��ʵ����
 * @author xiaoyang
 *
 */
public class Book {
	private int id;					//ͼ����
	private String bookName;		//ͼ������
	private String author;			//ͼ������
	private String sex;				//�����Ա�
	private Float price;			//ͼ��۸�
	private Integer bookTypeId;		//ͼ�����ͱ��
	private String bookTypeName;	//ͼ����������
	private String bookDesc;		//��ע
	
	//���췽��
	public Book(int id, String bookName, String author, String sex, Float price, Integer bookTypeId,
			String bookTypeName, String bookDesc) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.sex = sex;
		this.price = price;
		this.bookTypeId = bookTypeId;
		this.bookTypeName = bookTypeName;
		this.bookDesc = bookDesc;
	}
	
	public Book(String bookName, String author, String sex, Float price, String bookTypeName, String bookDesc) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.sex = sex;
		this.price = price;
		this.bookTypeName = bookTypeName;
		this.bookDesc = bookDesc;
	}

	public Book(){
		
	}


	public Book(String bookName, String author, String sex, Float price, Integer bookTypeId, String bookDesc) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.sex = sex;
		this.price = price;
		this.bookTypeId = bookTypeId;
		this.bookDesc = bookDesc;
	}

	public Book(String bookName, String author, Integer bookTypeId) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.bookTypeId = bookTypeId;
	}

	public Book(int id, String bookName, String author, String sex, Float price, Integer bookTypeId, String bookDesc) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.sex = sex;
		this.price = price;
		this.bookTypeId = bookTypeId;
		this.bookDesc = bookDesc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getBookTypeId() {
		return bookTypeId;
	}

	public void setBookTypeId(Integer bookTypeId) {
		this.bookTypeId = bookTypeId;
	}

	public String getBookTypeName() {
		return bookTypeName;
	}

	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}

	public String getBookDesc() {
		return bookDesc;
	}

	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	
	
}

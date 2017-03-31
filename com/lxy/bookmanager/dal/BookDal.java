package com.lxy.bookmanager.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lxy.bookmanager.model.Book;
import com.lxy.bookmanager.util.StringUtil;
/**
 * BookDal类
 * @author xiaoyang
 *
 */
public class BookDal {
	/**
	 * 图书增加操作	
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Book book) throws Exception{
		String sql="insert into t_book values(null,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getSex());
		pstmt.setFloat(4, book.getPrice());
		pstmt.setInt(5, book.getBookTypeId());
		pstmt.setString(6, book.getBookDesc());
		
		return pstmt.executeUpdate();
	}
	/**
	 * 图书查询
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet query(Connection con,Book book) throws Exception{
		StringBuffer stringBuffer = new StringBuffer("select * from t_book b,t_booktype bt where b.bookTypeId=bt.id");
		if (StringUtil.isNotEmpty(book.getBookName())) {
			stringBuffer.append(" and b.bookName like '%"+book.getBookName()+"%'");
		}
		if (StringUtil.isNotEmpty(book.getAuthor())) {
			stringBuffer.append(" and b.author like '%"+book.getAuthor()+"%'");
		}
		if (book.getBookTypeId()!=null&&book.getBookTypeId()!=-1) {
			stringBuffer.append(" and b.bookTypeId ="+book.getBookTypeId());	
		}
		PreparedStatement pstmt=con.prepareStatement(stringBuffer.toString());
		return pstmt.executeQuery();
	}
	/**
	 * 图书修改
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int modify(Connection con,Book book) throws Exception{
		String sql="update t_book set bookName=?,author=?,sex=?,price=?,bookTypeId=?,bookDesc=? where id =?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getSex());
		pstmt.setFloat(4, book.getPrice());
		pstmt.setInt(5, book.getBookTypeId());
		pstmt.setString(6, book.getBookDesc());
		pstmt.setInt(7, book.getId());
		return pstmt.executeUpdate();
	}
	/**
	 * 图书删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id) throws Exception{
		String sql="delete from t_book where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	/**
	 * 查询指定图书类别下是否有图书存在
	 * @param con
	 * @param bookTypeId
	 * @return
	 * @throws Exception
	 */
	public boolean isBookExitsBookTypeId(Connection con,String bookTypeId) throws Exception{
		String sql="select * from t_book where bookTypeId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bookTypeId);
		ResultSet resultSet=pstmt.executeQuery();
		return resultSet.next();
		
	}
}

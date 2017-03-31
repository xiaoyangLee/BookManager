package com.lxy.bookmanager.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lxy.bookmanager.model.bookType;
import com.lxy.bookmanager.util.StringUtil;

/**
 * BookTypeDal��
 * @author xiaoyang
 */
public class BookTypeDal {
	/**
	 * ͼ���������Ӳ���
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,bookType bookType) throws Exception{
		String sql="insert into t_booktype values(null,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		return pstmt.executeUpdate();
		
	}
	/**
	 * ͼ������ѯ
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	
	public ResultSet query(Connection con,bookType bookType) throws Exception{
		StringBuffer stringBuffer=new StringBuffer("select * from t_booktype");
		if (StringUtil.isNotEmpty(bookType.getBookTypeName())) {
			stringBuffer.append(" where bookTypeName like '%"+bookType.getBookTypeName()+"%'");
		}
		PreparedStatement pstmt =con.prepareStatement(stringBuffer.toString());
		return pstmt.executeQuery();
	}
	/**
	 * ͼ������޸�
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int modify(Connection con,bookType bookType) throws Exception{
		String sql="update t_booktype set bookTypeName=?,bookTypeDesc=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		pstmt.setInt(3, bookType.getId());
		return pstmt.executeUpdate();
		
	}
	
	public int delete(Connection con,String id) throws Exception {
		String sql="delete from t_booktype where id =?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
}

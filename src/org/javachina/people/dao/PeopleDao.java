package org.javachina.people.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.javachina.connectionpool.ConnectionPool;
import org.javachina.people.dto.PeopleDto;

public class PeopleDao {
	
	public ArrayList<PeopleDto> queryAll(){
		ArrayList<PeopleDto> list = new ArrayList<>();
		Connection conn = ConnectionPool.getConnection();
		Statement stat = null;
		ResultSet rs =null;
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery("select id ,name ,age,birth,salary from people order by id");
			
			while(rs.next()){
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				Date birth = rs.getDate(4);
				double salary = rs.getDouble(5);
				PeopleDto people = new PeopleDto(id, name, age, birth, salary);
				list.add(people);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(stat!=null){
					stat.close();
				}
				if(conn!=null&&!conn.isClosed()){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	public int deleteById(int id){
		int result = 0;
		Connection conn = ConnectionPool.getConnection();
		Statement stat = null;
		try {
			stat = conn.createStatement();
			result = stat.executeUpdate("delete from People where id="+id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(stat!=null){
					stat.close();
				}
				if(conn!=null&&!conn.isClosed()){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public int add(PeopleDto dto){
		int result = 0;
		Connection conn = ConnectionPool.getConnection();
		PreparedStatement psmt =null;
		try {
			psmt = conn.prepareStatement("insert into People(id,name,age,birth,salary) values (seq_peopleid.nextval,?,?,?,?)");
			psmt.setString(1, dto.getName());
			psmt.setInt(2, dto.getAge());
			psmt.setDate(3, dto.getBirth());
			psmt.setDouble(4, dto.getSalary());
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(psmt!=null){
					psmt.close();
				}
				if(conn!=null&&!conn.isClosed()){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		System.out.println(new PeopleDao().queryAll().size());
	}
}

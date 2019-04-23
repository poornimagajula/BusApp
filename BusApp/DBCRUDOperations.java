package com.regnant.BusApp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBCRUDOperations {
	Connection connection = DBConnection.getConnection();
	PreparedStatement pstmt;
	Statement stmt;
	public int addBus(BusBean b) {
		int rows_insert=0;
		try {
				String insert_Query="insert sample.bus_tbl values(?,?,?,?,?,?,?)";
				pstmt=connection.prepareStatement(insert_Query);
				pstmt.setInt(1, b.getId());
				pstmt.setString(2,b.getNo());
				pstmt.setString(3,b.getName());
				pstmt.setString(4,b.getSource());
				pstmt.setString(5,b.getDestination());
				pstmt.setDate(6,b.getDate());
				pstmt.setString(7,b.getType());
				rows_insert=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL Exception in Insert");
			e.printStackTrace();
		}		
		return rows_insert;		
	}
	public List<BusBean> getBus(BusBean bus) {
		List<BusBean> blist=new ArrayList<>();
		try {
			String select_query="select * from sample.bus_tbl where (Bus_From = ? and Bus_To = ?) and (Departure_Date=?)";
			pstmt = connection.prepareStatement(select_query);
			pstmt.setString(1, bus.getSource());
			pstmt.setString(2, bus.getDestination());
			pstmt.setDate(3, bus.getDate());
			System.out.println(bus.getSource()+"///////");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				BusBean b=new BusBean();
				b.setId(rs.getInt(1));
				b.setNo(rs.getString(2));
				b.setName(rs.getString(3));
				b.setSource(rs.getString(4));
				b.setDestination(rs.getString(5));
				b.setDate(rs.getDate(6));
				b.setType(rs.getString(7));
				System.out.println(b.Bus_id+"$$$$$");
				blist.add(b);
			}
			System.out.println(bus.getSource()+"*****");
			
		} catch (SQLException e) {
			System.out.println("SQL Exception in GetBus");
			e.printStackTrace();
		}
		
		return blist;
		
	}
//	public static void main(String[] args) {
//		DBCRUDOperations dbop= new DBCRUDOperations();
//		
//		List<BusBean> blist=dbop.getBus("Bangalore", "Guntur");
//		for(BusBean bb : blist) {
//			System.out.println(bb.Bus_From+"\t"+bb.Bus_Name+"@@@@@");
//		}
	//}

}

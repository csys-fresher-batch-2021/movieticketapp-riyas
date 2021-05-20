package in.riyasahamed.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.riyasahamed.dto.SeatDTO;
import in.riyasahamed.exceptions.DBException;
import in.riyasahamed.util.ConnectionUtil;

public class SeatDAO {

	// Creating Object
		private static final SeatDAO instance = new SeatDAO();

		// This Method returns the object which can be used for access methods in DAO
		public static SeatDAO getInstance() {
			return instance;
		}
		
		public List<SeatDTO> getSeatTypes(){
			
			List<SeatDTO> seatTypes;
			try {
				seatTypes = new ArrayList<>();
				
				Connection connection = ConnectionUtil.getConnection();
				
				String sql="select * from seat_types";
				
				PreparedStatement pst=connection.prepareStatement(sql);
				
				ResultSet result=pst.executeQuery();
				
				while(result.next()) {
					String seatType=result.getString("seat_type");
					int price=result.getInt("price");
					SeatDTO seat=new SeatDTO(seatType,price);
					seatTypes.add(seat);
				}
				
				ConnectionUtil.closeConnection(result, pst, connection);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DBException("Unable to Get Seat Types");
				
			}
			
			return seatTypes;
		}
		
}

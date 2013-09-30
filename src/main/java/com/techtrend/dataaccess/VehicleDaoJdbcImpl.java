package com.techtrend.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techtrend.dataaccess.VehicleDao;
import com.techtrend.domain.Vehicle;

@Repository
public class VehicleDaoJdbcImpl implements VehicleDao {
	
	private final JdbcOperations jdbcOperations;
	
	@Autowired
	public VehicleDaoJdbcImpl(JdbcOperations jdbcOperations){
		if(jdbcOperations == null){
			throw new IllegalArgumentException("jdbcOperation cannot be null");
		}
		
		this.jdbcOperations = jdbcOperations;
	}
	
	

	@Override
	public int insert(final Vehicle vehicle) {
        if (vehicle == null) {
            throw new IllegalArgumentException("userToAdd cannot be null");
        }
        
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.jdbcOperations.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(
                        "insert into vehicle (color, wheel, seat) values ( ?, ?, ?)", new String[] { "id" });
                ps.setString(1, vehicle.getColor());
                ps.setInt(2, vehicle.getWheel());
                ps.setInt(3, vehicle.getSeat());
                return ps;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
	}

	@Override
	public void update(Vehicle vehicle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Vehicle vehicle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(readOnly=true)
	public Vehicle findByVehicleNo(String vehicleNo) {
        if (vehicleNo == null) {
            throw new IllegalArgumentException("vehicleNo cannot be null");
        }
        try {
            return jdbcOperations.queryForObject(VEHICLE_QUERY + "vehicle_no = ?", VEHICLE_MAPPER, vehicleNo);
        } catch (EmptyResultDataAccessException notFound) {
            return null;
        }
	}
	
	private static final String VEHICLE_QUERY = "select id color, wheel, seat from vehicle where ";
	private static final RowMapper<Vehicle> VEHICLE_MAPPER = new VehicleRowMapper("calendar_users."); 
	
    static class VehicleRowMapper implements RowMapper<Vehicle> {
        private final String columnLabelPrefix;

        /**
         * Creates a new instance that allows for a custom prefix for the columnLabel.
         *
         * @param columnLabelPrefix
         */
        public VehicleRowMapper(String columnLabelPrefix) {
            this.columnLabelPrefix = columnLabelPrefix;
        }

        public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNo(rs.getString("vehicle_no"));
            vehicle.setColor(rs.getString("color"));
            vehicle.setWheel(rs.getInt("wheel"));
            vehicle.setSeat(rs.getInt("seat"));
            
            return vehicle;
        }
    };

}

package com.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.dto.EmployeeTO;

@Repository
public class EmployeeDao {

	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	
	public List<EmployeeTO> getAllEmployeeDetails(){
		//JdbcTemplate jdbcTemplate =jdbcDao.getJdbcTemplate();
		//List<EmployeeTO> employees = new ArrayList<>();
		
		String sql = "SELECT * FROM EMPLOYEE";
		List<EmployeeTO> employeesList = jdbcTemplate.query(sql, new RowMapper<EmployeeTO>() {

			@Override
			public EmployeeTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmployeeTO employee = new EmployeeTO();
	
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setEmail(rs.getString("email"));
				employee.setDateOfBirth(rs.getString("date_of_birth"));
				employee.setPhoneNumber(rs.getString("phone_number"));
				employee.setBloodGroup(rs.getString("blood_group"));
				
				return employee;
			}
			
		});

		return employeesList;
	}

	public void saveOrUpdate(EmployeeTO employee) {
		if (null!= employee.getId() && employee.getId() > 0) {
			// update
			String sql = "UPDATE dbo.EMPLOYEE SET NAME=?,EMAIL=?,DATE_OF_BIRTH=?,PHONE_NUMBER=?,BLOOD_GROUP=? WHERE id=?";
			jdbcTemplate.update(sql, employee.getName(),employee.getEmail(),employee.getDateOfBirth(),employee.getPhoneNumber(),employee.getBloodGroup(),employee.getId());
		} else {
			// insert
			String sql = "INSERT INTO dbo.EMPLOYEE (NAME,EMAIL,DATE_OF_BIRTH,PHONE_NUMBER,BLOOD_GROUP)"
						+ " VALUES (?,?,?,?,?)";
			jdbcTemplate.update(sql, employee.getName(),employee.getEmail(),employee.getDateOfBirth(),employee.getPhoneNumber(),employee.getBloodGroup());
		}
		
	}

	public void delete(int employeeId) {
		String sql = "DELETE FROM dbo.EMPLOYEE WHERE id=?";
		jdbcTemplate.update(sql, employeeId);
		//employeesList.removeIf(s->s.getId().equals(employeeId));
	}

	public EmployeeTO getEmployeeByEmployeeId(int employeeId) {
		String sql = "SELECT * FROM dbo.EMPLOYEE WHERE id=" + employeeId;
	return jdbcTemplate.query(sql, new ResultSetExtractor<EmployeeTO>() {

		@Override
		public EmployeeTO extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			if (rs.next()) {
				EmployeeTO employee = new EmployeeTO();
				employee.setId(rs.getInt("id"));
				employee.setName(rs.getString("name"));
				employee.setEmail(rs.getString("email"));
				employee.setDateOfBirth(rs.getString("date_of_birth"));
				employee.setPhoneNumber(rs.getString("phone_number"));
				employee.setBloodGroup(rs.getString("blood_group"));
				
				return employee;
			}
			
			return null;
		}
		
	});}


}

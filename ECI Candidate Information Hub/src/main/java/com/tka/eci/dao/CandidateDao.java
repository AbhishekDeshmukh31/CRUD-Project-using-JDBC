package com.tka.eci.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.tka.eci.entity.Candidate;
import com.tka.eci.utility.CandidateUtility;

public class CandidateDao {

	Candidate candidate;
	Connection connection;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;

	public List<Candidate> getallCandidates() {

		String query = "SELECT * FROM electioncommisionofindia.candidate;";
		List<Candidate> list = new ArrayList<Candidate>();
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = CandidateUtility.getConnection();
			st = connection.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				int SrNo = rs.getInt(1);
				String Name = rs.getString(2);
				String PartyName = rs.getString(3);
				String Assembly = rs.getString(4);
				String Gender = rs.getString(5);
				int Age = rs.getInt(6);
				Candidate candidate = new Candidate(Name, PartyName, Assembly, Gender, Age);
				list.add(candidate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Candidate> getcandidatebypartyname(String pn) {
		String selectquery = "select * from candidate where PartyName =?;";
		connection = CandidateUtility.getConnection();
		List<Candidate> list = new ArrayList<Candidate>();
		try {
			pst = connection.prepareStatement(selectquery);
			pst.setString(1, pn);
			rs = pst.executeQuery();

			while (rs.next()) {
				int SrNo = rs.getInt(1);
				String Name = rs.getString(2);
				String PartyName = rs.getString(3);
				String Assembly = rs.getString(4);
				String Gender = rs.getString(5);
				int Age = rs.getInt(6);
				Candidate candidate = new Candidate(Name, PartyName, Assembly, Gender, Age);
				list.add(candidate);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	public String insertCandidate(String name, String partyname, String assembly, String gender, int age) {

		String result = null;
		String addQuery = "INSERT INTO electioncommisionofindia.candidate(Name, PartyName, Assembly, Gender, Age)VALUES(?,?,?,?,?);";

		try {
			connection = CandidateUtility.getConnection();
			pst = connection.prepareStatement(addQuery);

			pst.setString(1, name);
			pst.setString(2, partyname);
			pst.setString(3, assembly);
			pst.setString(4, gender);
			pst.setInt(5, age);

			int rowsaffected = pst.executeUpdate();

			if (rowsaffected > 0) {
				result = "Data Inserted Successfully";

			} else {
				result = "Data not inserted ! ";
			}
			return result;

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("Error");
		}
		return result;
	}

	public String updateCandidateData(String partyname, String assembly,String gender, int age, String name) {

		String updatequery = "UPDATE electioncommisionofindia.candidate SET PartyName=?, Assembly=?, Gender =? ,Age=? WHERE Name = ?;";
		String rsult = null;
		try {
			connection = CandidateUtility.getConnection();

			pst = connection.prepareStatement(updatequery);

			pst.setString(1, partyname);
			pst.setString(2, assembly);
			pst.setString(3, gender);
			pst.setInt(4, age);
			pst.setString(5, name);

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				rsult = "Candidate data Updated Successfully";

			} else {
				rsult = "Candidate data not updated successfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rsult;
	}

	public String updateCandidatePartyName(String partyname, String name) {

		String updatequery = "UPDATE electioncommisionofindia.candidate SET PartyName=? WHERE Name = ?;";
		String result = null;
		try {
			connection = CandidateUtility.getConnection();

			pst = connection.prepareStatement(updatequery);

			pst.setString(1, partyname);
			pst.setString(2, name);

			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				result = "Candidate PartyName Updated Successfully";

			} else {
				result = "Candidate PartyName not updated successfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public String updateCandidateAssembly(String assembly, String name) {

		String updatequery = "UPDATE electioncommisionofindia.candidate SET Assembly = ?, WHERE Name = ?;";
		String result = null;
		try {
			connection = CandidateUtility.getConnection();
			pst = connection.prepareStatement(updatequery);
			pst.setString(1, assembly);
			pst.setString(2, name);

			int rowsAffected = pst.executeUpdate();
			if (rowsAffected > 0) {
				result = "Candidate Assembly Updated Successfully";

			} else {
				result = "Candidate Assembly not updated successfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public String updateCandidateGender(String gender, String name) {

		String updatequery = "UPDATE electioncommisionofindia.candidate SET Gender = ? WHERE Name = ?;";
		String result = null;
		try {
			connection = CandidateUtility.getConnection();
			pst = connection.prepareStatement(updatequery);
			pst.setString(1, gender);
			pst.setString(2, name);

			int rowsAffected = pst.executeUpdate();
			if (rowsAffected > 0) {
				result = "Candidate Gender Updated Successfully";

			} else {
				result = "Candidate Gender not updated successfully";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public String updateCandidateAge(int age, String name) {

		String updatequery = "UPDATE electioncommisionofindia.candidate SET Age = ? WHERE Name = ?;";
		String result = null;
		try {
			connection = CandidateUtility.getConnection();
			pst = connection.prepareStatement(updatequery);
			pst.setInt(1, age);
			pst.setString(2, name);

			int rowsAffected = pst.executeUpdate();
			if (rowsAffected > 0) {
				result = "Candidate Age Updated Successfully";

			} else {
				result = "Candidate Age not updated ";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public String updateCandidateName(String name, String pname, String assembly) {

		String updatequery = "UPDATE electioncommisionofindia.candidate SET Name = ? WHERE PartyName = ? AND Assembly = ? ";
		String result = null;
		try {
			connection = CandidateUtility.getConnection();
			pst = connection.prepareStatement(updatequery);
			pst.setString(1, name);
			pst.setString(2, pname);
			pst.setString(3, assembly);

			int rowsAffected = pst.executeUpdate();
			if (rowsAffected > 0) {
				result = "Candidate Name Updated Successfully";

			} else {
				result = "Candidate Name not updated ";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public String deleteCandidate(String name) {

		String result = null;
		String deleteQuery = "DELETE FROM electioncommisionofindia.candidate where Name = ?";

		try {
			connection = CandidateUtility.getConnection();
			pst = connection.prepareStatement(deleteQuery);
			pst.setString(1, name);
			int rowsaffected = pst.executeUpdate();

			if (rowsaffected > 0) {
				result = "Data Deleted Successfully";
			} else {
				result = "Data not deleted ! ";
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return result;

	}

}

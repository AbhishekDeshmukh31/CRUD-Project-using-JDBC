package com.tka.eci.service;

import java.util.List;

import com.tka.eci.dao.CandidateDao;
import com.tka.eci.entity.Candidate;

public class CandidateService {

	CandidateDao dao;

	public List<Candidate> getallCandidatesService() {
		dao = new CandidateDao();
		List<Candidate> allcandidates = dao.getallCandidates();
		return allcandidates;
	}

	public List<Candidate> getCandidatesbypnameService(String p) {
		dao = new CandidateDao();
		List<Candidate> allcandidates = dao.getcandidatebypartyname(p);
		return allcandidates;
	}

	public String addCandidateService(String n, String pn, String a, String g, int ag) {
		String result = null;
		dao = new CandidateDao();
		List<Candidate> currentlist = dao.getallCandidates();
		int count = 0;
		for (Candidate c : currentlist) {
			if (c.getName().equalsIgnoreCase(n)) {
				count++;
			}
		}
		if (count == 0) {
			result = dao.insertCandidate(n, pn, a, g, ag);
		} else {
			result = "Player already present";
		}
		return result;
	}

	public String updateCandidateService(String pn, String a, String g,int ag, String n) {
		String result = null;
		dao = new CandidateDao();
		result = dao.updateCandidateData(pn, a,g, ag, n);
		return result;
	}

	public String updateCandidatePartyService(String pn, String n) {
		String result = null;
		dao = new CandidateDao();
		result = dao.updateCandidatePartyName(pn, n);
		return result;
	}
	
	public String updateCandidateAssemblyService(String a, String n) {
		String result = null;
		dao = new CandidateDao();
		result = dao.updateCandidateAssembly(a, n);
		return result;
	}
	
	public String updateCandidateGenderService(String g, String n) {
		String result = null;
		dao = new CandidateDao();
		result = dao.updateCandidateGender(g, n);
		return result;
	}
	
	public String updateCandidateAgeService(int ag, String n) {
		String result = null;
		dao = new CandidateDao();
		result = dao.updateCandidateAge(ag, n);
		return result;
	}
	
	public String updateCandidateNameService(String n, String pn, String a) {
		String result = null;
		dao = new CandidateDao();
		result = dao.updateCandidateName(n,pn,a);
		return result;
	}

	public String deleteCandidateService(String n) {
		String result = null;
		dao = new CandidateDao();

		List<Candidate> list = dao.getallCandidates();
		int count = 0;
		for (Candidate c : list) {
			if (c.getName().equalsIgnoreCase(n)) {
				count++;
			}
		}
		if (count != 0) {
			result = dao.deleteCandidate(n);
		} else {
			result = "Candidate Data was not deleted";
		}
		return result;
	}
}

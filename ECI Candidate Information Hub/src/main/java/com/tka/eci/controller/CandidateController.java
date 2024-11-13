package com.tka.eci.controller;

import java.util.List;
import com.tka.eci.entity.Candidate;
import com.tka.eci.service.CandidateService;

public class CandidateController {

	CandidateService service;

	public List<Candidate> getallCandidatesController() {
		service = new CandidateService();
		List<Candidate> getallCandidates = service.getallCandidatesService();
		return getallCandidates;
	}

	public List<Candidate> getcandidatesbypnameController(String p) {
		service = new CandidateService();
		List<Candidate> partyname = service.getCandidatesbypnameService(p);
		return partyname;
	}

	public String addcandidatesController(String n, String pn, String a, String g, int ag) {
		service = new CandidateService();
		String res = service.addCandidateService(n, pn, a, g, ag);
		return res;
	}

	public String updatecandidateDataController(String pn, String a, String g, int ag, String n) {
		service = new CandidateService();
		String res = service.updateCandidateService(pn, a, g, ag, n);
		return res;
	}

	public String updatecandidatePartyController(String pn, String n) {
		service = new CandidateService();
		String res = service.updateCandidatePartyService(pn, n);
		return res;
	}

	public String updatecandidateAssemblyController(String a, String n) {
		service = new CandidateService();
		String res = service.updateCandidateAssemblyService(a, n);
		return res;
	}

	public String updatecandidateGenderController(String g, String n) {
		service = new CandidateService();
		String res = service.updateCandidateGenderService(g, n);
		return res;
	}

	public String updatecandidateAgeController(int ag, String n) {
		service = new CandidateService();
		String res = service.updateCandidateAgeService(ag, n);
		return res;
	}

	public String updatecandidateNameController(String n, String pn, String a) {
		service = new CandidateService();
		String res = service.updateCandidateNameService(n, pn, a);
		return res;
	}

	public String deletecandidatesController(String n) {
		service = new CandidateService();
		String res = service.deleteCandidateService(n);
		return res;
	}
}

package logic;

import java.util.ArrayList;

import model.DimayorModel;
import model.Team;
import utils.DimayorUtils;

public class DimayorLogic {
	
	private DimayorModel model;
	private DimayorUtils utils;
	
	public DimayorLogic() {
		model= new DimayorModel();
		utils= new DimayorUtils();
	}
	
	public ArrayList<Team> getTeamsList() {
		return model.getTeamList();
	}
	
	public Team getTeamIfo(String name) {
		return model.getTeamInfo(name);
	}

	public int editTeam(String body) {
		
		try {
			
			Team team= utils.teamFromJson(body);
			
			if(getTeamIfo(team.getName())!=null) {
				
				if(team.getYear()!=0) {
					
					model.editTeam(team);
					return 200;
				}
			}else {
				System.out.println("no encontrado");
				return 400;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return 400;
		}
		
		return 500;
		
	}
	
	public int deleteTeam(String name) {
		
		ArrayList<Team> teamList= model.getTeamList();
		
		for(Team t:teamList) {
			if(t.getName().equalsIgnoreCase(name)) {
				model.deleteTeam(t);
				return 200;
			}
		}
		
		return 400;

	}
	
	public int addTeam(String body) {
		
		try {
			Team team= utils.teamFromJson(body);
			
			ArrayList<Team> teamList= model.getTeamList();
			
			for(Team t:teamList) {
				if(t.equals(team)) {
					return 400;
				}
			}
			
			if(team.getName()== null || team.getName().equals("")) {
				return 400;
			}
			
			if(team.getYear()==0) {
				return 400;
			}
			
			model.addTeam(team);
			
			return 200;
		}
		catch(Exception e) {
			e.printStackTrace();
			return 400;
		}
		
		
	}
}

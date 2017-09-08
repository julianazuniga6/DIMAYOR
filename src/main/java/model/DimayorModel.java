package model;

import java.util.ArrayList;

public class DimayorModel {
	
	private ArrayList<Team> teamList;
	
	public DimayorModel() {
		initialize();
	}
	
	
	public void initialize() {
		
		teamList= new ArrayList<>();
		
		Team a= new Team("America", 1927, 13);
		teamList.add(a);
		
		Team b= new Team("Cali", 1912, 9);
		teamList.add(b);
		
		Team c= new Team("Junior", 1924, 7);
		teamList.add(c);
	}
	
	
	public ArrayList<Team> getTeamList() {
		return teamList;
	}


	public Team getTeamInfo(String name) {
		for(Team team :teamList) {
			if(team.getName().equalsIgnoreCase(name)) {
				return team;
			}
		}
		return null;
	}


	public void editTeam(Team team) {
		
		for(Team t :teamList) {
			if(t.getName().equalsIgnoreCase(team.getName())) {
				t.setTitles(team.getTitles());
				t.setYear(team.getYear());
			}
		}
		
	}


	public void deleteTeam(Team team) {
		
		teamList.remove(team);

	}


	public void addTeam(Team newTeam) {
		
		teamList.add(newTeam);

	}
	
	

}

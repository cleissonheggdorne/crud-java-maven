package cleissonheggdorne.first_crud_maven.entities;

import java.io.Serializable;

public class TeamLeague implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Team team;
	private League league;
	private int position;
	private int punctuation;
	
	public TeamLeague() {
		
	}

	public TeamLeague(Team team, League league, int position, int punctuation) {
		super();
		this.team = team;
		this.league = league;
		this.position = position;
		this.punctuation = punctuation;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getPunctuation() {
		return punctuation;
	}

	public void setPunctuation(int punctuation) {
		this.punctuation = punctuation;
	}

	@Override
	public String toString() {
		return "TeamLeague [team=" + team + ", league=" + league + ", position=" + position + ", punctuation="
				+ punctuation + "]";
	}
	
	

}

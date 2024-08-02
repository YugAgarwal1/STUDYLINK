import java.util.*;
public class Team<T extends Player> implements Comparable<Team<T>>{
	private String name;
	private ArrayList<T> players;
	private int won;
	private int lost;
	private int tie;
	private int played;

	public Team(String name){
		this.name = name;
		this.won = this.lost = this.tie = this.played = 0;
		players = new ArrayList<>();
	}

	public void setName(String name) { this.name = name; }
	public String getName() { return this.name; }
	public int getNumOfPlayers() { return this.players.size(); }

	public boolean addPlayer(T player){
		if(players.contains(player)){
			System.out.println(this.name + "already contains" + player.getName());
			return false;
		}

		this.players.add(player);
		System.out.println(player.getName() + "added to " + this.name + "team!");
		return true;
	}

	public int ranking(){
		return 2*this.won + this.tie;
	}

	public void matchResult(Team<T> opponent , int ourScore , int theirScore){
		String msg = " ";
		if(ourScore > theirScore){
			won++;
			msg = " defeats ";
		}
		else if(theirScore > ourScore){
			lost++;
			msg = " lost to ";
		}
		else if(theirScore == ourScore){
			tie++;
			msg = " drew with ";
		}

		played++;

		if(opponent !=null ){
			opponent.matchResult(null , theirScore ,ourScore);
			System.out.println(this.name + msg + opponent.name);
		}
	}

	@Override
	public int compareTo(Team<T> opponent){
		if(this.ranking() > opponent.ranking()){
			return -1;
		}
		if(this.ranking() < opponent.ranking()){
			return 1;
		}
		return 0;
	}
}
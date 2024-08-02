import java.util.*;
public class Album{
	private String name;
	private String artist;
	private ArrayList<Song> songs;
	public Album(String name , String artist){
		this.name  = name;
		this.artist = artist;
		this.songs = new ArrayList<>();
	}
	public boolean addSong(Song song){
		if(findSong(song.getName())==null){
			return songs.add(song);
		}
		return false;
	}
	public boolean addSong(String name, double duration , String artist){
		if(findSong(name)==null){
	       Song song = new Song(name,duration,artist);
	       return songs.add(song);
		}
		return false;
	}
	private Song findSong(String name){
		for(Song song : songs){
			if(song.getName().equalsIgnoreCase(name)){
				return song;
			}
		}
		return null;
	}

	public boolean addToPlaylist(int trackNumber , Collection<Song> playlist){
		int trackIndex = trackNumber -1;
		if(trackIndex >=0 && trackIndex<songs.size()){
			playlist.add(songs.get(trackIndex));
			return true;
		}
	return false;
	}
  public boolean addToPlaylist(String songName,Collection<Song> playlist){
  	Song song = findSong(songName);
  	if(song!=null){
  		playlist.add(song);
  		return true;
  	}
  	return false;
  }
}
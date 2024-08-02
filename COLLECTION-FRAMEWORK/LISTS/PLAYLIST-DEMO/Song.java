public class Song implements Comparable<Song>{
	private String name;
    private double duration ;
    private String artist;
    public Song(String name , double duration , String artist){
    	this.name = name ;
    	this.duration = duration;
    	this.artist = artist;
    } 
    public String getName(){return name;}
    public double getDuration(){return duration ;}
    public String getArtist(){return artist;}

    @Override
    public int compareTo(Song otherSong){return this.name.compareTo(otherSong.name);}
    @Override
    public String toString(){
    	return "["+this.name+", "+this.duration+", "+this.artist+"]";
    }
}
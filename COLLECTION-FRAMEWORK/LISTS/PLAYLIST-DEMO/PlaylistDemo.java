		
import java.util.*;
public  class PlaylistDemo{
	public static void main(String[] args) {
		ArrayList<Album> albums = new ArrayList<>();

    	Album album = new Album("Best of Arijit Singh", "Arijit Singh");
    	album.addSong("Ae dil hai mushkil", 4.29, "Arijit Singh");
    	album.addSong("Zaalima", 5.18, "Arijit Singh");
    	album.addSong("Tere Bina", 5.30, "Arijit Singh");
    	album.addSong("Nashe si chad gayi", 3.56, "Arijit Singh");
    	album.addSong("Galti se mistake", 6.15, "Arijit Singh");
    	
    	albums.add(album);

    	album = new Album("Top 100 Songs of Sonu", "Sonu Nigam");
    	album.addSong("Sonu Ae dil hai mushkil", 4.29, "Sonu Nigam");
    	album.addSong("Sonu Zaalima", 5.18, "Sonu Nigam");
    	album.addSong("Sonu Tere Bina", 5.30, "Sonu Nigam");
    	album.addSong("Sonu Nashe si chad gayi", 3.56, "Sonu Nigam");
    	album.addSong("Sonu Galti se mistake", 6.15, "Sonu Nigam");

    	albums.add(album);

		LinkedList<Song> playlist1 = new LinkedList<>();
    	albums.get(0).addToPlaylist(1, playlist1);
    	albums.get(0).addToPlaylist("Tere Bina", playlist1);
    	albums.get(0).addToPlaylist(5, playlist1);
    	albums.get(0).addToPlaylist(50, playlist1);
    	albums.get(1).addToPlaylist("Sonu Zaalima", playlist1);
    	albums.get(1).addToPlaylist("Sonu Galti se mistake", playlist1);
    	albums.get(1).addToPlaylist("Sonu Se Gavaya Hi Nahi Hai!", playlist1);
play(playlist1);
	}
    private static void printMenu(){
    	System.out.println("--------------AVAILABLE OPTIONS----------------");
    	System.out.println("1. To Quit");
    	System.out.println("2. NExt song");
    	System.out.println("3. Previous Song");
    	System.out.println("4. Replay the Current Song");
    	System.out.println("5.List the menu in the playlist");
    	System.out.println("6. Print the Menu");
    	System.out.println("7.Delete the current song");
    }

	private static void printPlaylist(Iterator<Song> iterator){
		System.out.println("--------------BEG OF PLAYLIST-------------");
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println("--------------END OF PLAYLIST-------------");
	}
	private static void play(LinkedList<Song> playlist){
		if(playlist.size()<=0){
			System.out.println("No songs in your playlist! please add and thhen play");
			return ;
		}
		Scanner scanner = new Scanner(System.in);
		boolean goingforward  = true ;
		ListIterator<Song> listIterator = playlist.listIterator();
		System.out.println("Now Playing : "+listIterator.next());
		boolean quit = false;
		printMenu();
		while(!quit){
			int choice = scanner.nextInt();
			switch(choice){
			case 1 :
				quit = true;
				break;
			case 2 :
				if(!goingforward){
					if(listIterator.hasNext()){
						listIterator.next();
					}
					goingforward = true;
				}
				if(listIterator.hasNext()){
					System.out.println("Now playing  : "+listIterator.next());
				}
				else{
					System.out.println("you have reached the end of the playlist");
				}
				break;
			case 3:
				if(goingforward){
					if(listIterator.hasPrevious()){
						listIterator.previous();
					}
					goingforward = false;
				}
				if(listIterator.hasPrevious()){
					System.out.println("Now playing : "+listIterator.previous());
				}
				else{
					System.out.println("you have reached beginning of the pplaylist");
				}
				break;
			case 4 :
				if(goingforward){
					System.out.println("Now playing "+listIterator.previous());
					goingforward = false;
				}
				else{
					System.out.println("Now playing : "+listIterator.next());
					goingforward = true;
				}
				break;
			case 5: 
				printPlaylist(playlist.iterator());
				break;
			case 6 :
				printMenu();
				break;
			case 7 :
				listIterator.remove();
				System.out.println("Song removed");
				break;
			}
		}
	}
}
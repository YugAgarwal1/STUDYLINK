public class CustomGeneric {
	public static void main(String[] args) {
		FootballPlayer sunil = new FootballPlayer("SUNIL CHHETRI");
		CricketPlayer kohli = new CricketPlayer("VIRAT KOHLI");
		CricketPlayer rohit = new CricketPlayer("ROHIT SHARMA");
		HockeyPlayer sumit = new HockeyPlayer("SUMIT KUMAR");
		Team<CricketPlayer> rcb = new Team<>("RCB");
		Team<CricketPlayer> mi = new Team<>("MI");
		Team<FootballPlayer> banglore = new Team<>("FCB");

		Tournament<> ipl = new Tournament<>("IPL");
        ipl.addTeam(rcb);
        ipl.addTeam(banglore);
		// rcb.addPlayer(kohli);
		// rcb.addPlayer(sunil);

		// mi.addPlayer(rohit);
		// mi.addPlayer(sumit);

		// rcb.matchResult(mi,206,200);
	    // Team<String> badTeam = new Team<>("Bad Team");
		// badTeam.addPlayer("HELLO WORLD");
                                       	   }
}

/**
 * LOWER GENERIC : Something extends ClassName
 * UPPER GENERIC : Something super ClassName
 */
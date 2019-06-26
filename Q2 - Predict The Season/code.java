import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		String s = "";
		File fixtureFile = new File("fixture.csv");
		Scanner fixtureScanner = null;
		try {
			fixtureScanner = new Scanner(fixtureFile);
		} catch (FileNotFoundException e) {
			System.out.println("Error!");
		}
		String [][] games = new String [392][6];//id,home,power1,pewer2,score1,score2,
		String[][] players = new String [194][3];//name,totalScore,gamesPlayed
		String id,home,score1,score2;
		fixtureScanner.nextLine();
		while(fixtureScanner.hasNextLine()) {
			Scanner lineScanner = new Scanner(fixtureScanner.nextLine());
			lineScanner.useDelimiter(",");
			id=lineScanner.next();
			lineScanner.next();
			home=lineScanner.next();
			lineScanner.next();
			lineScanner.next();
			score1=lineScanner.next();
			score2=lineScanner.next();
			lineScanner.close();
			games[Integer.parseInt(id)-1][0] =id;
			games[Integer.parseInt(id)-1][1] =home;
			games[Integer.parseInt(id)-1][2] ="0.0";
			games[Integer.parseInt(id)-1][3] ="0.0";
			games[Integer.parseInt(id)-1][4] =score1;
			games[Integer.parseInt(id)-1][5] =score2;
		}
		fixtureScanner.close();

		
		File squadFile = new File("2022_2023_season_squads.csv");
		//System.out.println("File Size: "+squadFile.length());
		int playerNo=0;
		BufferedReader br1 = null;
		try {
			br1 = new BufferedReader(new FileReader(squadFile));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			br1.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		boolean bo1=true;
		while(bo1) {
			String ab=null;
			try {
				ab = br1.readLine();
			} catch (IOException e) {
				
			}
			if(ab!=null) {
				Scanner lineScanner = new Scanner(ab);
				//System.out.println(aa);
				lineScanner.useDelimiter(",");
				String name = lineScanner.next();
				if(name.contains(" ")) {
					name = name.substring(name.lastIndexOf(" ")+1);
				}
				players[playerNo][0] = name;
				players[playerNo][1] = "0.0";
				players[playerNo][2] = "0.0";
				playerNo++;
				lineScanner.close();
			}
			else {
				bo1=false;
			}
			
		}

		File playerFile = new File("player_data.csv");
		//System.out.println("File Size: "+playerFile.length());
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(playerFile));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			br.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		boolean bo=true;
		while(bo) {
			String currentTeam;
			String playerPower;
			String playerName;
			String aa;
			try {
				aa = br.readLine();
			} catch (IOException e) {
				break;
			}
			if(aa!=null) {
				Scanner lineScanner = new Scanner(aa);
				lineScanner.useDelimiter(",");
				id=lineScanner.next();
				playerName = lineScanner.next();
				if(playerName.contains(" ")) {
					playerName = playerName.substring(playerName.lastIndexOf(" ")+1);
				}

				currentTeam=lineScanner.next();
				lineScanner.next();//date
				playerPower=lineScanner.next();
				
				for(int i=0;i<194;i++) {
					if(playerName.equals(players[i][0])&&!playerPower.equals("")) {
						players[i][1]= Double.toString(Double.parseDouble(players[i][1])+Double.parseDouble(playerPower));
						players[i][2]=Double.toString(Double.parseDouble(players[i][2])+1.0);
						break;
					}
				}
				//System.out.println(id+"  "+currentTeam +"  "+playerPower);
				if(currentTeam.equals(games[Integer.parseInt(id)-1][1])&&!playerPower.equals("")) {
					games[Integer.parseInt(id)-1][2]=""+(Double.parseDouble(games[Integer.parseInt(id)-1][2])+Double.parseDouble(playerPower));
				}
				else if (!playerPower.equals("")){
					games[Integer.parseInt(id)-1][3]=""+(Double.parseDouble(games[Integer.parseInt(id)-1][3])+Double.parseDouble(playerPower));
				}
				lineScanner.close();
			}
			else {
				bo=false;
			}
			
		}
		System.out.println(Arrays.deepToString(players));
		System.out.println(Arrays.deepToString(games));
		//System.out.println(idPlayers[3][1]);
		double diff=0;
		
		for(int i=0;i<392;i++) {
			diff+=(Double.parseDouble(games[i][4])-Double.parseDouble(games[i][5]))/(Double.parseDouble(games[i][2])-Double.parseDouble(games[i][3]));
		}
		double averageDiff=diff/392.0;
		System.out.println("Average score difference for 1 power: "+averageDiff);
		//player id:
		//Arsenal:0-23
		//bARCELONA:24-47
		//FC Bayern:48-73
		//Chelsea:74-95
		//Juventus:96-117
		//Liverpool:118-141
		//Man utd:142-164
		//R Madrid:165-193
		double arsenalScore=0;
		double barcelonaScore=0;
		double bayernScore=0;
		double chelseaScore=0;
		double juventusScore=0;
		double liverpoolScore=0;
		double manutdScore=0;
		double madridScore=0;
		
		for(int i=0;i<=23;i++) {if(Double.parseDouble(players[i][2])!=0) {arsenalScore+=Double.parseDouble(players[i][1])/Double.parseDouble(players[i][2]);}}
		for(int i=24;i<=47;i++) {if(Double.parseDouble(players[i][2])!=0) {barcelonaScore+=Double.parseDouble(players[i][1])/Double.parseDouble(players[i][2]);}}
		for(int i=48;i<=73;i++) {if(Double.parseDouble(players[i][2])!=0) {bayernScore+=Double.parseDouble(players[i][1])/Double.parseDouble(players[i][2]);}}
		for(int i=74;i<=95;i++) {if(Double.parseDouble(players[i][2])!=0) {chelseaScore+=Double.parseDouble(players[i][1])/Double.parseDouble(players[i][2]);}}
		for(int i=96;i<=117;i++) {if(Double.parseDouble(players[i][2])!=0) {juventusScore+=Double.parseDouble(players[i][1])/Double.parseDouble(players[i][2]);}}
		for(int i=118;i<=141;i++) {if(Double.parseDouble(players[i][2])!=0) {liverpoolScore+=Double.parseDouble(players[i][1])/Double.parseDouble(players[i][2]);}}
		for(int i=142;i<=164;i++) {if(Double.parseDouble(players[i][2])!=0) {manutdScore+=Double.parseDouble(players[i][1])/Double.parseDouble(players[i][2]);}}
		for(int i=165;i<=193;i++) {if(Double.parseDouble(players[i][2])!=0) {madridScore+=Double.parseDouble(players[i][1])/Double.parseDouble(players[i][2]);}}
		arsenalScore = arsenalScore*11/23+23/2.0;
		barcelonaScore = barcelonaScore*11/23+23/2.0;
		bayernScore = bayernScore*11/25+25/2.0;
		chelseaScore = chelseaScore*11/21+21/2.0;
		juventusScore = juventusScore*11/21+21/2.0;
		liverpoolScore = liverpoolScore*11/23+23/2.0;
		manutdScore= manutdScore*11/22+22/2.0;
		madridScore = madridScore*11/28+28/2.0;
		System.out.println("----------------------------------------");
		System.out.println(arsenalScore);
		System.out.println(madridScore);
		System.out.println("Predicted match results:");
		System.out.println();
		
		File matchFile = new File("test_fixture.csv");
		double[] powerDiff = new double[56];
		int j =0;
		BufferedReader br2 = null;
		try {
			br2 = new BufferedReader(new FileReader(matchFile));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			br2.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		boolean bo2=true;
		while(bo2) {
			String aaa;
			try {
				aaa = br2.readLine();
			} catch (IOException e) {
				break;
			}
			if(aaa!=null) {

					double difference =0;
					Scanner lScanner = null;
					try {
						lScanner = new Scanner(aaa);
						lScanner.useDelimiter(",");		
					} catch (Exception e) {
						System.out.println("Error!");
						e.printStackTrace();
					}
					lScanner.next();
					lScanner.next();
					String team1 = lScanner.next();
					String team2 = lScanner.next();
					if(team1.equals("Arsenal")) {
						difference += arsenalScore;
					}
					else if(team1.equals("Barcelona")) {
						difference += barcelonaScore;
					}
					else if(team1.equals("FC Bayern")) {
						difference +=bayernScore;
					}
					else if(team1.equals("Chelsea")) {
						difference += chelseaScore;
					}
					else if(team1.equals("Juventus")) {
						difference += juventusScore;
					}
					else if(team1.equals("Liverpool")) {
						difference += liverpoolScore;
					}
					else if(team1.equals("Man Utd")) {
						difference += manutdScore;
					}
					else if(team1.equals("R. Madrid")) {
						difference += madridScore;
					}
					
					if(team2.equals("Arsenal")) {
						difference -= arsenalScore;
					}
					else if(team2.equals("Barcelona")) {
						difference -= barcelonaScore;
					}
					else if(team2.equals("FC Bayern")) {
						difference -= bayernScore;
					}
					else if(team2.equals("Chelsea")) {
						difference -= chelseaScore;
					}
					else if(team2.equals("Juventus")) {
						difference -= juventusScore;
					}
					else if(team2.equals("Liverpool")) {
						difference -= liverpoolScore;
					}
					else if(team2.equals("Man Utd")) {
						difference -= manutdScore;
					}
					else if(team2.equals("R. Madrid")) {
						difference -= madridScore;
					}
					powerDiff[j]=difference;
					j++;
			}
			else {
				bo2=false;
			}
		}
			
		Scanner matchScanner=null;
		try {
			matchScanner = new Scanner(matchFile);
			matchScanner.useDelimiter(",");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		double predictedGap;
		System.out.println(matchScanner.nextLine());
		System.out.println();
		for(int i=0;i<56;i++) {
			//System.out.println(powerDiff[i]);
			predictedGap = powerDiff[i]*averageDiff+0.3;//0.3 home advantage
			if(predictedGap>0) {
				System.out.println(matchScanner.nextLine()+","+(Math.round(predictedGap)+1)+",1");
			}
			else {
				System.out.println(matchScanner.nextLine()+",1"+","+(Math.round((-1)*predictedGap)+1));
			}
			
		}
	}
}

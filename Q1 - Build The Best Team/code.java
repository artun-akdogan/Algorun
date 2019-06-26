import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		String s = "";
		File inputFile = new File("player_pool.csv");
		Scanner inputScanner = null;
		try {
			inputScanner = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			System.out.println("Error!");
		}
		
		int stc=0; int aml=0; int amr=0; int mc=0; int dm=0; int dl=0;int dc=0; int dr=0; int gk=0;
		inputScanner.nextLine();//to exclude the namings of the values
		while(inputScanner.hasNextLine()) {
			Scanner lineScanner = new Scanner(inputScanner.nextLine());
			lineScanner.useDelimiter(",");
			lineScanner.next();
			lineScanner.next();
			s = lineScanner.next();
			
			
			if(s.contains("STC")) {
				stc++;
			}
			if(s.contains("AML")) {
				aml++;
			}
			if(s.contains("AMR")) {
				amr++;
			}
			if(s.contains("MC")) {
				mc++;
			}
			if(s.contains("DM")) {
				dm++;
			}
			if(s.contains("DL")) {
				dl++;
			}
			if(s.contains("DC")) {
				dc++;
			}
			if(s.contains("DR")) {
				dr++;
			}
			if(s.contains("GK")) {
				gk++;
			}
			lineScanner.close();
		}
		inputScanner.close();
		
		
		double[][] stcList = new double[stc][4];
		double[][] amlList = new double[aml][4];
		double[][] amrList = new double[amr][4];
		double[][] mcList = new double[mc][4];
		double[][] dmList = new double[dm][4];
		double[][] dlList = new double[dl][4];
		double[][] dcList = new double[dc][4];
		double[][] drList = new double[dr][4];
		double[][] gkList = new double[gk][4];
		
		Scanner rowScanner = null;
		try {
			rowScanner = new Scanner(inputFile);
		} catch (FileNotFoundException e) {
			System.out.println("Error!");
		}
		int cstc=0; int caml=0; int camr=0; int cmc=0; int cdm=0; int cdl=0;int cdc=0; int cdr=0; int cgk=0;
		rowScanner.nextLine();//to exclude the namings of the values
		while(rowScanner.hasNextLine()) {
			Scanner lineScanner2 = new Scanner(rowScanner.nextLine());
			lineScanner2.useDelimiter(",");
			double id = 0;
			try {id = Double.parseDouble(lineScanner2.next());}
			catch(Exception e){System.out.println("Error!");}
			
			lineScanner2.next();
			
			s = lineScanner2.next();
			
			double value = 0;
			try {value = Double.parseDouble(lineScanner2.next());}
			catch(Exception e){System.out.println("Error!");}
			lineScanner2.next();
			lineScanner2.next();
			lineScanner2.next();//prefered foot
			lineScanner2.next();
			lineScanner2.next();
			lineScanner2.next();//personality
			
			int acc = lineScanner2.nextInt();
			int wor = lineScanner2.nextInt();
			int vis = lineScanner2.nextInt();
			int thr = lineScanner2.nextInt();
			int pun = lineScanner2.nextInt();
			int tec = lineScanner2.nextInt();
			int tea = lineScanner2.nextInt();
			int tck = lineScanner2.nextInt();
			int str = lineScanner2.nextInt();
			int sta = lineScanner2.nextInt();
			int rus = lineScanner2.nextInt();
			int ref = lineScanner2.nextInt();
			int pos = lineScanner2.nextInt();
			int pen = lineScanner2.nextInt();
			int pas = lineScanner2.nextInt();
			int pac = lineScanner2.nextInt();
			int v1 = lineScanner2.nextInt();
			int otb = lineScanner2.nextInt();
			int nat = lineScanner2.nextInt();
			int mar = lineScanner2.nextInt();
			int lth = lineScanner2.nextInt();
			int lon = lineScanner2.nextInt();
			int ldr = lineScanner2.nextInt();
			int kic = lineScanner2.nextInt();
			int jum = lineScanner2.nextInt();
			int hea = lineScanner2.nextInt();
			int han = lineScanner2.nextInt();
			int fre = lineScanner2.nextInt();
			int fla = lineScanner2.nextInt();
			int fir = lineScanner2.nextInt();
			int fin = lineScanner2.nextInt();
			int ecc = lineScanner2.nextInt();
			int dri = lineScanner2.nextInt();
			int det = lineScanner2.nextInt();
			int dec = lineScanner2.nextInt();
			int cro = lineScanner2.nextInt();
			int cor = lineScanner2.nextInt();
			int cnt = lineScanner2.nextInt();
			int cmp = lineScanner2.nextInt();
			int com = lineScanner2.nextInt();
			int cmd = lineScanner2.nextInt();
			int bra = lineScanner2.nextInt();
			int bal = lineScanner2.nextInt();
			int ant = lineScanner2.nextInt();
			int agi = lineScanner2.nextInt();
			int agg = lineScanner2.nextInt();
			int aer = lineScanner2.nextInt();
			
			
			double score = 0;
			
			
			if(s.contains("STC")) {
				score = jum*3+str*6+tea*4+dec*4+pac*3+dri*3+otb*6+tec*4+fin*8;
				stcList[cstc][0] = id;
				stcList[cstc][1] = score;
				stcList[cstc][2] = value;
				stcList[cstc][3] = score;
				cstc++;
			}
			if(s.contains("AML")) {
				score = tea*5+pas*6+pac*3+dri*5+otb*6+tec*6+fin*1+fla*4+tck*4;
				amlList[caml][0] = id;
				amlList[caml][1] = score;
				amlList[caml][2] = value;
				amlList[caml][3] = score;
				caml++;
			}
			if(s.contains("AMR")) {
				score = tea*5+pas*6+pac*3+dri*5+otb*6+tec*6+fin*1+fla*4+tck*4;
				amrList[camr][0] = id;
				amrList[camr][1] = score;
				amrList[camr][2] = value;
				amrList[camr][3] = score;
				camr++;
			}
			if(s.contains("MC")) {
				score = jum*4+tck*4+pos*3+tea*7+pas*7+dec*7+sta*5+fla*4+dri*3;
				mcList[cmc][0] = id;
				mcList[cmc][1] = score;
				mcList[cmc][2] = value;
				mcList[cmc][3] = score;
				cmc++;
			}
			if(s.contains("DM")) {
				score = jum*4+tck*4+pos*3+tea*7+pas*7+dec*7+sta*5+fla*5+dri*6+otb*5+pac*4;
				dmList[cdm][0] = id;
				dmList[cdm][1] = score;
				dmList[cdm][2] = value;
				dmList[cdm][3] = score;
				cdm++;
			}
			if(s.contains("DL")) {
				score = tck*9+pos*6+tea*5+pas*5+dec*7+dri*4+sta*4;
				dlList[cdl][0] = id;
				dlList[cdl][1] = score;
				dlList[cdl][2] = value;
				dlList[cdl][3] = score;
				cdl++;
			}
			if(s.contains("DC")) {
				score = jum*7+tck*7+str*7+pos*4+tea*4+pas*4+dec*7;
				dcList[cdc][0] = id;
				dcList[cdc][1] = score;
				dcList[cdc][2] = value;
				dcList[cdc][3] = score;
				cdc++;
			}
			if(s.contains("DR")) {
				score = tck*9+pos*6+tea*5+pas*5+dec*7+dri*4+sta*4;
				drList[cdr][0] = id;
				drList[cdr][1] = score;
				drList[cdr][2] = value;
				drList[cdr][3] = score;
				cdr++;
			}
			if(s.contains("GK")) {
				score = aer*3+pos*3+agi*9+han*7+ref*9+kic*5+dec*4+lth*3+lon*3;
				gkList[cgk][0] = id;
				gkList[cgk][1] = score;
				gkList[cgk][2] = value;
				gkList[cgk][3] = score;
				cgk++;
			}
			lineScanner2.close();
		}
		rowScanner.close();
		System.out.println("GK:");
		java.util.Arrays.sort(gkList, java.util.Comparator.comparingDouble(a -> a[3]));
		for(int i=gk-1;i>=gk-100;i--) {
			System.out.println(gkList[i][0]+"\t"+gkList[i][1]+"\t"+gkList[i][2]/1000000+" m\t"+gkList[i][3]);
		}
		System.out.println("");
		System.out.println("");
		System.out.println("STC:");
		java.util.Arrays.sort(stcList, java.util.Comparator.comparingDouble(a -> a[3]));
		for(int i=stc-1;i>=stc-100;i--) {
			System.out.println(stcList[i][0]+"\t"+stcList[i][1]+"\t"+stcList[i][2]/1000000+" m\t"+stcList[i][3]);
		}
		System.out.println("");
		System.out.println("");
		System.out.println("AML:");
		java.util.Arrays.sort(amlList, java.util.Comparator.comparingDouble(a -> a[3]));
		for(int i=aml-1;i>=aml-100;i--) {
			System.out.println(amlList[i][0]+"\t"+amlList[i][1]+"\t"+amlList[i][2]/1000000+" m\t"+amlList[i][3]);
		}
		System.out.println("");
		System.out.println("");
		System.out.println("AMR:");
		java.util.Arrays.sort(amrList, java.util.Comparator.comparingDouble(a -> a[3]));
		for(int i=amr-1;i>=amr-100;i--) {
			System.out.println(amrList[i][0]+"\t"+amrList[i][1]+"\t"+amrList[i][2]/1000000+" m\t"+amrList[i][3]);
		}
		System.out.println("");
		System.out.println("");
		System.out.println("MC:");
		java.util.Arrays.sort(mcList, java.util.Comparator.comparingDouble(a -> a[3]));
		for(int i=mc-1;i>=mc-100;i--) {
			System.out.println(mcList[i][0]+"\t"+mcList[i][1]+"\t"+mcList[i][2]/1000000+" m\t"+mcList[i][3]);
		}
		System.out.println("");
		System.out.println("");
		System.out.println("DM:");
		java.util.Arrays.sort(dmList, java.util.Comparator.comparingDouble(a -> a[3]));
		for(int i=gk-1;i>=gk-100;i--) {
			System.out.println(dmList[i][0]+"\t"+dmList[i][1]+"\t"+dmList[i][2]/1000000+" m\t"+dmList[i][3]);
		}
		System.out.println("");
		System.out.println("");
		System.out.println("DL:");
		java.util.Arrays.sort(dlList, java.util.Comparator.comparingDouble(a -> a[3]));
		for(int i=dl-1;i>=dl-100;i--) {
			System.out.println(dlList[i][0]+"\t"+dlList[i][1]+"\t"+dlList[i][2]/1000000+" m\t"+dlList[i][3]);
		}
		System.out.println("");
		System.out.println("");
		System.out.println("DR:");
		java.util.Arrays.sort(drList, java.util.Comparator.comparingDouble(a -> a[3]));
		for(int i=dr-1;i>=dr-100;i--) {
			System.out.println(drList[i][0]+"\t"+drList[i][1]+"\t"+drList[i][2]/1000000+" m\t"+drList[i][3]);
		}
		System.out.println("");
		System.out.println("");
		System.out.println("DC:");
		java.util.Arrays.sort(dcList, java.util.Comparator.comparingDouble(a -> a[3]));
		for(int i=dc-1;i>=dc-100;i--) {
			System.out.println(dcList[i][0]+"\t"+dcList[i][1]+"\t"+dcList[i][2]/1000000+" m\t"+dcList[i][3]);
		}
		
		inputScanner.close();
	}
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.naming.directory.InvalidAttributesException;

import Tokarski.TokarskiIndex;
import Tokarski.TokarskiLine;
import Wildcards.*;

public class Wczytawanie {


	public static void main(String[] args) {
		Dictionary dict = new Dictionary();
		dict.read("dataFiles/slownik.txt");
		
		//build set of wildcards
		Set<Wildcard> wildcardSet = new HashSet<Wildcard>();
		wildcardSet.add(new Bracket());
		wildcardSet.add(new Blank());
		wildcardSet.add(new Consonant());
		wildcardSet.add(new Dash());
		wildcardSet.add(new DashVowel());
		wildcardSet.add(new Dot());
		wildcardSet.add(new DotConsonant());
		wildcardSet.add(new Vowel());
		String wildcardStr = "-VC.(";
		
		TokarskiLine tokLine = new TokarskiLine(wildcardStr);
		TokarskiIndex indexTok = new TokarskiIndex(tokLine);
		indexTok.load("dataFiles/indeksTok.txt");
		
		
		
		try {
			Analyser morphologic = new Analyser(dict, indexTok,wildcardSet);
			try {
				Scanner txtFile = new Scanner(new File(args[0]));
				txtFile.useDelimiter("[^A-Za-ząęćęłńóśżź]");
				while(txtFile.hasNext()){
					String word = txtFile.next();
					if(word.length()!=0)
						morphologic.analyse(word.toLowerCase());
				}
			} catch (FileNotFoundException e) {
				System.out.println("cannot find the text file");
			}
		} catch (InvalidAttributesException e1) {
			e1.printStackTrace();
		} 
		
	}

}

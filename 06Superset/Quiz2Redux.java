import java.util.*;

public class Quiz2Redux{  
    public static ArrayList<String> combinations(String s){
	ArrayList<String> words = new ArrayList<String>();
	help(words , s, "", 0);
	Collections.sort(words);
	return words;
    }
    
    private static void help( ArrayList<String> words, String s, String sub, int index){
	if(index == s.length()){
	    words.add(sub);
	    return;
	}

	help(words, s, sub, index+1);
	help(words, s, sub + s.charAt(index), index+1);
    }
}

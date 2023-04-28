package org.howard.edu.lsp.finals.problem;

@SuppressWarnings("serial")
public class SongsDatabaseException extends Exception{
	
    public SongsDatabaseException(){
        super();
    }
	
    public SongsDatabaseException(String str){
        super(str);
    }
}

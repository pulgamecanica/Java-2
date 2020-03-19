import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class ListFiles{
	
	public static void main(String[] args){
		ListFiles lf = new ListFiles();
		if(args[0].equals("-r"))
			lf.findAllFiles(args[1]);
		else
			lf.findFirstFiles(args[0]);
	}
	public void findAllFiles(String rootPath){
		File root = new File(rootPath);
		File[] list = root.listFiles();
        list = root.listFiles();
        for (File f : list) {
            if (f.isDirectory()) {
                findFirstFiles(f.getPath());
                //System.out.println( f.getPath() + "/" + f.getName() );
            }
            else {
                System.out.println( "FilePath : " + f.getPath());
            }
        }
	}
	public void findFirstFiles(String rootPath){
		File root = new File(rootPath);
        File[] list = root.listFiles();
        for (File f : list){
        	if (!f.isDirectory()) 
        		 System.out.println( "FilePath : " + f.getPath());
        	else
        		findAllFiles(rootPath);
     	}
	}
}
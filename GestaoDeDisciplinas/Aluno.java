import java.io.*;
import java.util.*;

public class Aluno{
	private final int idAluno;
	private String nome;
	//disciplinasDoAluno.add("LEI");

	//*
	/* 
	construtor para criar aluno
	get notas
	get disciplinas
	get numero
	get nome
	*/
	public Aluno(String name, int idAluno){
		nome = name;
		this.idAluno = idAluno;
	}
	public String getName(){
		return nome;
	}
	public int getId(){
		return idAluno;
	}
	public static String getName(String line){
		String[] name = line.split(" ");
		String[] nameCreator = new String[name.length-1];
		for(int i = 1; i < name.length; i++)
			nameCreator[i-1] = name[i];
		String joinedString = String.join(" ", nameCreator);
		return joinedString;
	}
	public static int getNumber(String line){
		String[] number = line.split(" ");
		return Integer.parseInt(number[0]);
	}
	public static List<Aluno> AlunoCreatorWithFileSeed(String fileName){
		List<Aluno> studentsList = new ArrayList<Aluno>();
		File file = new File(fileName);
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				studentsList.add(new Aluno(getName(line), getNumber(line)));
				System.out.println(getNumber(line)+": "+getName(line));
			}
				scanner.close();
		}
		catch (FileNotFoundException e) {
			System.err.println("ficheiro nao encontrado");
		}
		return studentsList;
	}
}
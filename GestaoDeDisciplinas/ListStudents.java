import java.util.*;
import java.io.*;
import static java.lang.System.out;

public class ListStudents{
	public static void main(String[] args){
		//getStudents(args[0]);
		Disciplina d1 = inscreveJa(args[0]);
		getDisciplinaInfo("teste1.txt", d1);

	}
	public static void getStudents(String fileName){
		File file = new File(fileName);
		try{
			Scanner scanner = new Scanner(file);
			System.out.println("*****************************************************Listagem de alunos*******************************************************");
				Aluno.AlunoCreatorWithFileSeed(fileName);
			System.out.println("******************************************************************************************************************************");
			scanner.close();
		}
		catch(FileNotFoundException e){
			System.err.println("ficheiro nao encontrado");
		}
	}
	public static Disciplina inscreveJa(String fileName){
		File file = new File(fileName);
		Disciplina d1 = null;
		try{
			Scanner scanner = new Scanner(file);
			System.out.println("*****************************************************Incricoes de alunos*******************************************************");
			d1 = Disciplina.DisciplineCreatorWithFileSeed(fileName);
			System.out.println("******************************************************************************************************************************");
			scanner.close();
		}
		catch(FileNotFoundException e){
			System.err.println("ficheiro nao encontrado");
		}
		return d1;
	}
	public static void getDisciplinaInfo(String fileName, Disciplina disciplina){
		Disciplina.createDisciplineFile(fileName, disciplina);
	}
}
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import static java.lang.System.out;

public class Test{
	public static void main(String[] args){
		//SEEDS :D
		getStudents();
		Aluno a1 = new Aluno("Manel", 1);
		Aluno a2 = new Aluno("Margarita", 2);
		Aluno a3 = new Aluno("Leonor", 3);
		Aluno a4 = new Aluno("Ana", 4);
		Aluno a5 = new Aluno("Claudia", 5);
		Aluno a6 = new Aluno("Ixchel", 6);
		Aluno a7 = new Aluno("Sofia", 7);
		Aluno a8 = new Aluno("Penny", 8);
		Aluno a9 = new Aluno("Olga", 9);
		Aluno a10 = new Aluno("Besek", 10);
		Aluno a11 = new Aluno("Tomas", 11);
		Aluno a12 = new Aluno("Tiago", 12);
		Aluno a13 = new Aluno("Gonçalo", 13);
		Aluno a14 = new Aluno("Arturo", 14);
		Aluno a15 = new Aluno("Bruno", 15);
		Disciplina d1 = new Disciplina("Programaçao Orientada a Objetps","POO", 30);
		Disciplina d2 = new Disciplina("Lagos e Educacao Internacional","LEI", 13);
		Disciplina d3 = new Disciplina("PooP :V","POO",20);
		//Devia devolver uma exexao pois PooP tem 0 vagas disponiveis, capacidade = 0
		d1.inscreverAluno(a1, d1);
		d1.inscreverAluno(a2, d1);
		d1.inscreverAluno(a3, d1);
		d1.inscreverAluno(a4, d1);
		d1.inscreverAluno(a5, d1);
		d1.inscreverAluno(a6, d1);
		d1.inscreverAluno(a7, d1);
		d1.inscreverAluno(a8, d1);
		d1.inscreverAluno(a9, d1);
		d1.inscreverAluno(a10, d1);
		d2.inscreverAluno(a1, d2);
		d2.inscreverAluno(a2, d2);
		d2.inscreverAluno(a3, d2);
		d2.inscreverAluno(a4, d2);
		d2.inscreverAluno(a5, d2);
		d2.inscreverAluno(a6, d2);
		d2.inscreverAluno(a7, d2);
		d2.inscreverAluno(a8, d2);
		d2.inscreverAluno(a9, d2);
		d3.inscreverAluno(a1, d3);
		d3.inscreverAluno(a2, d3);
		d3.inscreverAluno(a1, d3);
		d3.inscreverAluno(a3, d3);
		d3.inscreverAluno(a4, d3);
		d3.inscreverAluno(a5, d3);
		d3.inscreverAluno(a6, d3);
		d3.inscreverAluno(a7, d3);
		d3.inscreverAluno(a8, d3);
		//Notas
		d1.setGrade(13, 1);
		d1.setGrade(14, 2);
		d1.setGrade(15, 3);
		d1.setGrade(11, 4);
		d1.setGrade(12, 5);
		d1.setGrade(13, 6);
		d1.setGrade(9, 7);
		d1.setGrade(20, 8);
		d1.setGrade(14, 9);
		d2.setGrade(13, 1);
		d2.setGrade(11, 2);
		d2.setGrade(11, 3);
		d2.setGrade(16, 4);
		d2.setGrade(17, 5);
		d2.setGrade(18, 6);
		d2.setGrade(11, 7);
		d2.setGrade(6, 8);
		d2.setGrade(3, 9);
		d2.setGrade(4, 10);
		d2.setGrade(16, 11);
		d2.setGrade(15, 12);
		d3.setGrade(18, 1);
		d3.setGrade(19, 2);
		d3.setGrade(7, 3);
		d3.setGrade(20, 4);
		d3.setGrade(13, 5);
		d3.setGrade(12, 6);
		d3.setGrade(12, 7);
		d3.setGrade(13, 8);
		d3.setGrade(14, 9);
		d3.setGrade(15, 10);
		d3.setGrade(17, 11);
		d3.setGrade(17, 12);
		Disciplina[] ds = {d1,d2,d3};
		for(int i = 0; i < ds.length; i++){
			System.out.println("******************************************Alunos de " + ds[i].disciplinaNameid + "(" + ds[i].sigla + "), Capacidade:" + ds[i].capacidade + "******************************************" );
			for(int j = 0; j < ds[i].inscricoes.size(); j++){
				System.out.println("Nome " + ds[i].inscritos.get(j).getName() + "**********Nota: " + ds[i].inscricoes.get(j).getNota() + "*********************" );
			}
		}
		//Examples *********:D:D:D:D:D:D:D:D:D:D:D:D:D:D:*********
		String execPath = System.getProperty("user.dir");
		System.out.println(execPath);
		File dir = new File(execPath);
		boolean exists = dir.exists(); 
		boolean isFile = dir.isFile(); // false;
		boolean isDir = dir.isDirectory(); // true;
		File parent = dir.getParentFile(); // /Users/Viriato
		File child = new File(dir, "Test.class"); //...iato/Project/Program.class
		File[] children = dir.listFiles();
		File file = new File("estudantes.txt");
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				out.println(line);
			}
			scanner.close(); //Kinda optional
		}
		catch (FileNotFoundException e) {
			System.err.println("ficheiro nao encontrado");
		}
		out.println("*************************************************************Exercicio Do Pedro**********************************");
		List<Aluno> alunosparacrear = new ArrayList<Aluno>();
		alunosparacrear.add(a1);
		alunosparacrear.add(a2);
		alunosparacrear.add(a3);
		alunosparacrear.add(a4);
		alunosparacrear.add(a5);
		alunosparacrear.add(a6);
		alunosparacrear.add(a7);
		alunosparacrear.add(a8);
		d1.paraOPedro(args[0], alunosparacrear);
		out.println("*******************************************************************Fim Exercicio do Pedro*****************************************");

	}
	public static void printLines(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			out.println(line);
		}
		scanner.close();
	}
	public static void getStudents(){
		out.println("************************************************************************************************************");
		Aluno.AlunoCreatorWithFileSeed("estudantes.txt");
		out.println("************************************************************************************************************");
	}
}
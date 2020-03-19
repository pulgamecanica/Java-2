import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class Disciplina{
	public String disciplinaNameid;
	public String sigla;
	public int capacidade;
	public List<Aluno> inscritos = new ArrayList<Aluno>();
	public List<Inscricao> inscricoes = new ArrayList<Inscricao>();
	//*
	/*
	construtor para crear disciplina
	Increver aluno
	desenscrever aluno
	lancer nota
	tem nota
	obter nota
	nota media
	melhores alunos
	*/
	public Disciplina(String name, String sigla, int capacidade){
		if(capacidade == 0)
			throw new IllegalArgumentException("Nao é possivel criar uma disciplina com 0 capacidade");
		disciplinaNameid = name;
		this.sigla = sigla;
		this.capacidade = capacidade;
	}

	public boolean isAvailable(){
		if(inscritos.size()>=capacidade)
			return false;
		return true;
	}

	public void inscreverAluno(Aluno aluno, Disciplina disciplina){
		if(isAvailable()){
			Inscricao inscricao = new Inscricao(disciplina, aluno);
			inscritos.add(aluno);
			inscricoes.add(inscricao);
		}
	}

	public void desenscreverAluno(int numeroAluno){
		Aluno alunoDesinscrito;
		for(Aluno x : inscritos){
			if(numeroAluno == x.getId()){
				alunoDesinscrito = x;
				inscritos.remove(alunoDesinscrito);
				return;
			}
		}
		throw new IllegalArgumentException("Couln't find any onyone with that ID, sorry....Not a student of this Discipline");
	}
	public void setGrade(int grade, int numeroAluno){
		if(grade > 0 && grade <= 20){
			Inscricao alunoAvaliado;
			for(Inscricao x : inscricoes){
				if(numeroAluno == x.getIdAluno()){
					alunoAvaliado = x;
					alunoAvaliado.setNota(grade);
					return;
				}
			}
			//throw new IllegalArgumentException("Couln't find any onw with that ID, sorry....");
		}
	}
	//Asumindo que ningem pode ter 0, pois o tipo primitivo int nao é null, comeza por 0 ;( Expliquem melhor no enunciado!!!
	public boolean alunoavaliado(int numeroAluno){
		Inscricao alunoAvaliado;
		for(Inscricao x : inscricoes){
			if(numeroAluno == x.getIdAluno()){
				alunoAvaliado = x;
				if(alunoAvaliado.avaliado())
					return true;
				else
					return false;
			}
		}
		throw new IllegalArgumentException("Couln't find any onw with that ID, sorry....");
	}
	public int getGrade(int numeroAluno){
		Inscricao alunoAvaliado;
		for(Inscricao x : inscricoes){
			if(numeroAluno == x.getIdAluno()){
				alunoAvaliado = x;
				return alunoAvaliado.getNota();
			}
		}
		throw new IllegalArgumentException("Couln't find any onw with that ID, sorry....");
	}
	public double average(){
		int counter = 0;
		int gradesSUM = 0;
		for(Inscricao x : inscricoes){
			if(alunoavaliado(x.getIdAluno())){
				gradesSUM += getGrade(x.getIdAluno());
				counter++;
			}
		}
		return ((double)gradesSUM)/((double)counter);
	}




	public static String getSignature(String name){
		String[] splitString = name.split(" ");
		String[] fixedSignature = new String[splitString.length];
		for(int i = 0; i < splitString.length; i++)
			if('A' <= splitString[i].charAt(0) && splitString[i].charAt(0) <= 'Z')
				fixedSignature[i] = Character.toString(splitString[i].charAt(0));
			else 
				fixedSignature[i] = "";
		String joinedSignature = String.join("", fixedSignature);
		return joinedSignature;
	}
	



	//Assuming perfect Files are being submited :D
	public static Disciplina DisciplineCreatorWithFileSeed(String fileName){
		//Create Students just because the exercise says so:
		List<Aluno> students = Aluno.AlunoCreatorWithFileSeed("estudantes.txt");
		File file = new File(fileName);
		boolean disciplineHasName = false;
		String disciplineName = "";
		Disciplina d1 = null;
		try {
			Scanner scanner = new Scanner(file);
			String title_line = scanner.nextLine();
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if(disciplineHasName){
					//dar as notas aos alunos
					int studentId = findStudent(line); 
					int grade = findGrade(line); 
					d1.setGrade(grade, studentId);
				}
				while(!disciplineHasName){
					disciplineName = title_line;
					d1 = new Disciplina(disciplineName, getSignature(disciplineName), 30);//**getSignature //CAPACIDADE!!!!!WTF ENUNCIADO assummir que tem 30 de capacidede ;I
					//inscreverAluno()
					for(Aluno x: students)
						d1.inscreverAluno(x, d1);
					System.out.println("Disciplina:  " + disciplineName + ", Sigla:  " + getSignature(disciplineName) + ", Capacidade: 30");
					disciplineHasName = true;
				}
			}
				scanner.close();
		}
		catch (FileNotFoundException e) {
			System.err.println("ficheiro nao encontrado");
		}
		return d1;
	}
	public static void DisciplineCreatorWithNameAnsStudentsSeed(String disciplineName, String stifentsFileName){
		Disciplina d1 = new Disciplina(disciplineName, getSignature(disciplineName), 30);
		List<Aluno> students = Aluno.AlunoCreatorWithFileSeed("estudantes.txt");
		for(Aluno x: students)
			d1.inscreverAluno(x, d1);
		createDisciplineFile(disciplineName, d1);
	}	


	public static int findStudent(String line){
		int studentId;
		String[] splitString = line.split(" ");
		return Integer.parseInt(splitString[0]);	
	}

	public static int findGrade(String line){
		int studentGrade;
		String[] splitString = line.split(" ");
		if(splitString[1].equals("NA"))
			return studentGrade = -1;
		else
			return studentGrade = Integer.parseInt(splitString[1]);
	}




	public void paraOPedro(String fileName, List<Aluno> students){
		//vou por todo aqui
		Scanner scanner = new Scanner(fileName);
		String title_line = scanner.nextLine();
		Disciplina d1 = new Disciplina(title_line, getSignature(title_line), 30);	
		for(Aluno x: students)
			//inscreverAluno é um método de Aluno
			d1.inscreverAluno(x, d1);
		darNotaAosAlunos(fileName, d1);
	}

	public static void darNotaAosAlunos(String fileName, Disciplina disciplina){
		File file = new File(fileName);
		try {
			Scanner scanner = new Scanner(file);
			String title_line = scanner.nextLine();
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if(line.contains("NA")){
					disciplina.setGrade(-1, findStudent(line));
					System.out.println(disciplina.disciplinaNameid + "Student Number:  " + findStudent(line) + "  Grade:" + findGrade(line));
				}
				else{
					disciplina.setGrade(findGrade(line), findStudent(line));
					System.out.println(disciplina.disciplinaNameid + "Student Number:  " + findStudent(line) + "  Grade:" +  findGrade(line));
				}
			}
		}
		catch (FileNotFoundException e) {
			System.err.println("ficheiro nao encontrado");
		}
	}


	public static void createDisciplineFile(String fileName, Disciplina disciplina){
		try {
			PrintWriter writer = new PrintWriter(new File(getSignature(fileName) + ".txt"));
			writer.println("Nome da Disciplina: " + disciplina.disciplinaNameid);
			writer.println("Sigla da disciplina: " + disciplina.sigla);
			for(Aluno x : disciplina.inscritos)
				writer.println(x.getId() + " " + ((disciplina.getGrade(x.getId()) == -1)? "NA" : disciplina.getGrade(x.getId())));
			//From here is extra stuff
			// System.out.println("Media da turma: " + disciplina.average());
			// disciplina.desenscreverAluno(1);
			// System.out.println("Desenscrever ao aluno 1: ");
			// System.out.println("*************************Listagem dos alunos de novo**************************** ");
			// for(Aluno x : disciplina.inscritos)
			// 	System.out.println(x.getId() + " " + ((disciplina.getGrade(x.getId()) == -1)? "NA" : disciplina.getGrade(x.getId())) + "  " + x.getName());
			// System.out.println("Disciplina disponivel??? " + disciplina.isAvailable());
			// System.out.println("Aluno 5 (avaliado? (should be false)(Clau): " + disciplina.alunoavaliado(5));
			// disciplina.setGrade(20, 5);
			// System.out.println("Set Grade to Clau (25): ");
			// System.out.println("Aluno 5 (avaliado? (should be true)(Clau): " + disciplina.alunoavaliado(5));
			// System.out.println("Claus grade =  " + disciplina.getGrade(5));
			// System.out.println("Media da turma : " + disciplina.average());
			// System.out.close();
			// writer.close();
		}
		catch (FileNotFoundException e) {
		System.err.println("problema a escrever o ficheiro");
		}
	}

	
}


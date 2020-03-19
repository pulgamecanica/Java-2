import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Inscricao{
	public int nota = -1;
	private Disciplina idDisciplina;
	private Aluno idAluno;
	//*
	/* get num de inscricao
	criar construtor COM Base no NUMERO de ALUNO e lanzae execoes
	caso nao posa inscrever
	*/
	public Inscricao(Disciplina idDisciplina, Aluno idAluno){
		this.idDisciplina = idDisciplina;
		this.idAluno = idAluno;
		System.out.println("Inscricao creada");
	}
	public void setNota(int nota){
		this.nota = nota;
		System.out.println("Nota dada" + nota + "   para o aluno:  " + idAluno.getName());
	}
	public boolean avaliado(){
		return nota != -1;
	}
	public int getIdAluno(){
		return idAluno.getId();
	}
	public String getIdDisciplina(){
		return idDisciplina.disciplinaNameid;
	}
	public int getNota(){
		return nota;
	}
}
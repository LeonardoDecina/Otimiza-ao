class Enfermeiro{

	public String nome;
	public int cofen;
	public int diasTrabalho[];
	public int preferencias[];
	public int pesosSetados[];

	public Enfermeiro(String nome, int cofen, int[] preferencias, int[] pesosSetados){
		this.nome = nome;
		this.cofen = cofen;
		this.preferencias = preferencias;
		this.pesosSetados = pesosSetados;
	}
}


class Trabalho{

	public int turno;

	public Trabalho(int turno){
		this.turno = turno;
	}
}


import java.util.Scanner;

public class Principal{

	Scanner read = new Scanner(System.in);
	int manha[] = new int[28];
	int tarde[] = new int[28];
	int noite[] = new int[28];
	final int p1 = 1;
	final int p2 = 2;
	final int p3 = 3;
	int quantEnferemeiros;
	int z = 0;
	Enfermeiro enfermeiros[];


	public void lerEnfermeiros(){
		for(int k = 0; k < quantEnferemeiros; k++){

			String nome = read.nextLine();
			int cofen = read.readInt();
			int auxDias[] = new int[28];
			int auxTurnos[] = new int[28];

			for(int w = 0; w < 28; w++){

				auxDias[w] = read.nextInt();
				auxTurnos[w] = read.nextInt();
			}
			enferemeiros[k] = new Enfermeiro(nome, cofen, auxDias, auxTurnos);
		}
	}

	public void funcaoObjetiva(){
		for(int i = 0; i < quantEnferemeiros; i++){
			for(int dias = 0; dias < 28; dias++){
				z = enfermeiros[i].preferencias[dias] * enfermeiros[i].pesosSetados[dias];
			}
		}
	}


	public static void main(String[] args){

		quantEnferemeiros = read.nextInt("Quantidade de Enfermeiros eh: ");
		enfermeiros[] = new int[quantEnferemeiros];
	}

}

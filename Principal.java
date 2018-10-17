class Enfermeiro{

	public String nome;
	public String cofen;
	//votor com a resposta final do quadro de horaro do enfermeiro
	public int diasTrabalho[];
	public int preferencias[];
	public int pesosSetados[];

	public Enfermeiro(String nome, String cofen, int[] preferencias, int[] pesosSetados){
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
	//vetores que contem a quantidade de enfermeiros minimo que um turno deve ter
	int manha[] = new int[28];
	int tarde[] = new int[28];
	int noite[] = new int[28];
	//variaveis que indicam a quandtidade atual de cada enferemeiro no turno especifico
	int manha = 0;
	int tarde = 0;
	int noite = 0;
	//peso para cada turno
	final int pesoManha = 1;
	final int pesoTarde = 2;
	final int pesoNoite = 3;
	int quantEnferemeiros;
	int z = 0;
	//vetor com a quantidade de enfermeiros contratados pelo hospital
	Enfermeiro enfermeiros[];


	//ler os enfermeiros de uma entrada padrao
	public void lerEnfermeiros(){
		for(int k = 0; k < quantEnferemeiros; k++){

			String nome = read.nextLine();
			String cofen = read.nextLine();
			int auxDias[] = new int[28];
			int auxTurnos[] = new int[28];

			for(int w = 0; w < 28; w++){

				auxDias[w] = read.nextInt();
				auxTurnos[w] = read.nextInt();
			}
			enferemeiros[k] = new Enfermeiro(nome, cofen, auxDias, auxTurnos);
		}
	}


	//primeira restricao que garante a quantidade minima e maxima de trabalho de cada enfermeiro
	public boolean restricao01(){
		int auxSoma = 0;

		for(int i = 0; i < quantEnferemeiros; i++){
			for(int dias = 0; dias < 28; dias++){
				if(enfermeiros[i].preferencias[dias] != 0){
					auxSoma++;
				}
			}
		}

		if(auxSoma >= 16 && auxSoma <= 24){
			return true;
		}

		return false;
	}


	//segunda restricao que garante a quantidade minima de enfermeiros em cada turno
	public boolean restricao02(){
		int auxSomaTM = 0;
		int auxSomaTT = 0;
		int auxSomaTN = 0;

		int auxSomaFolgaTM = 0;
		int auxSomaFolgaTT = 0;
		int auxSomaFolgaTN = 0;

		//faz os calculos de enfermeiros trabalhando e dos que estão de folga em cada turno
		for(int i = 0; i < quantEnferemeiros; i++){
			for(int dias = 0; dias < 28; dias++){
				if(enfermeiros[i].pesosSetados[dias] == 1){
					auxSomaTM++;
				}



				if(enfermeiros[i].pesosSetados[dias] == 2){
					auxSomaTT++;
				}



				if(enfermeiros[i].pesosSetados[dias] == 3){
					auxSomaTN++;
				}
			}
		}

		for(int i = 0; i < 28; i++){
			manha += manha[i];
			tarde += tarde[i];
			noite += noite[i];
		}

		//verifica se em cada turno há uma quantidade minima de enferemeiros disponiveis
		if((auxSomaTM - auxSomaFolgaTM >= manha) && 
		   (auxSomaTT - auxSomaFolgaTT >= tarde) &&
		   (auxSomaTN - auxSomaFolgaTN >= noite)){
			return true;
		}

		return false;
	}


	//funcao objetiva na qual queremos minimizar a quantidade de enfermeiros no hospital
	public void funcaoObjetiva(){
		for(int i = 0; i < quantEnferemeiros; i++){
			for(int dias = 0; dias < 28; dias++){
				z = enfermeiros[i].preferencias[dias] * enfermeiros[i].pesosSetados[dias];
			}
		}
	}


	public static void main(String[] args){

		quantEnferemeiros = read.nextInt();
		enfermeiros[] = new int[quantEnferemeiros];
	}

}
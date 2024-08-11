package CinemaMorfeu;

import java.util.ArrayList;

public class CineMorfeu {
       
	// Catalogo de Salas e Filmes
	private ArrayList<ASala> salas;
	private ArrayList<BFilme> filmes;
	// Maquina de Vender Bilhetes
	private  Bilheteria maquinaDeBilhetes;
	private double arrecadacao;
	
	
	public CineMorfeu() {
		this.salas = new ArrayList<>();
		this.filmes = new ArrayList<>();
		this.maquinaDeBilhetes = new Bilheteria();
	}

	public void adicionarSala(ASala sala) {
		this.salas.add(sala);
	}
	
	public void adicionarFilme(BFilme filme) {
		this.filmes.add(filme);
	}
	
	public void listarFilmes() {
		for( BFilme filme : this.filmes) {
			System.out.println(filme);
		}
	}
	public double getArrecadacao(){
            return this.arrecadacao;
    }
    public ArrayList<ASala> getSalas(){
            return this.salas;
    }
    public ArrayList<BFilme> getFilmes(){
            return this.filmes;
    }
	public void venderIngresso(BFilme filme, int quantidade) {
			double valorTotal = this.maquinaDeBilhetes.venderIngresso(filme, quantidade);
			this.arrecadacao += valorTotal;         
	}	
	public void definirValorIngresso(double valorIngresso) {
			this.maquinaDeBilhetes.setValorIngresso(valorIngresso);
	}

	
}


package CinemaMorfeu;

public class BFilme {
    private  int id;
    private  String  nome;
    private  String descricao;
    private  String tipo;
    private  int duracao;
    private  ASala sala;

    public BFilme(String titulo, String tipo, ASala sala, String descricao,int duracao) {
    	super();
    	this.nome = titulo;
    	this.tipo = tipo;
    	this.descricao = descricao;
    	this.sala = sala;
    	this.duracao = duracao;
    }

    public String toString() {
    	return    "___________________________________"
                    + "\n* ID do Filme: "+ id
                    + "\n* Titulo: " + nome
                    + "\n* Genero: " + tipo
                    + "\n* Sala: "+sala.getNomeSala()
                    + "\n* Descricao: "+descricao
                    + "\n* Horario: 20:50\n"
                    + "----------------------------------";
    }

    public String getNome() {
    		return nome;
    }
    public String getDescricao() {
    	return this.descricao;
    }
    public ASala getSala(){
    	return this.sala;
    }
    public String getTipo() {
    	return this.tipo;
    }
    public int getDuracao() {
    	return this.duracao;
    }
    public void setId(int id){
    	this.id = id;
    }
    public int getId(){
    	return this.id;
    }
}

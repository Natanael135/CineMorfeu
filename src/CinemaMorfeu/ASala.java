package CinemaMorfeu;

public class ASala {
  
	
	private int numero;
    private String nomeSala;
    private int capacidade;
    private double taxa;
    private String brinde;
    private String[] poltronas;
    private int cadVendidas;
    private int cadDisponiveis;
    
    
    public ASala(int numero, int capacidade, String nomeSala,double taxa, String brinde) {
			this.numero = numero;
			this.capacidade = capacidade;
            this.nomeSala = nomeSala;
            this.taxa = taxa;
            this.brinde = brinde;
            this.poltronas = new String[capacidade];
            this.cadDisponiveis=this.capacidade;
            iniciarPoltronas();
    }
    
    private void iniciarPoltronas(){
            for(int i=0;i<this.capacidade;i++){
                this.poltronas[i] = i+"";
            }
    }
    public void verPoltronas(int nSala){
        if(nSala == 1 || nSala == 2){
            int pos = 0;
            System.out.println("---------------- P O L T R O N A S SALA: "+this.getNomeSala()+"----------------------------");
            for(int i=0; i<5;i++){
                for(int j=0; j<40;j++){
                  System.out.print("\t["+this.poltronas[pos]+"]");
                  pos++;
             }
                System.out.println("\n");
            }
        }
        if(nSala == 3){
            int pos = 0;
            System.out.println("---------------- P O L T R O N A S [SALA "+this.getNomeSala()+"]----------------------------");
            for(int i=0; i<5;i++){
                for(int j=0; j<30;j++){
                  System.out.print("\t["+this.poltronas[pos]+"]");
                  pos++;
                }
                System.out.println("\n");
            }
    }
        if(nSala == 4){
            int pos = 0;
            System.out.println("---------------- P O L T R O N A S [SALA "+this.getNomeSala()+"]----------------------------");
            for(int i=0; i<5;i++){
                for(int j=0; j<20;j++){
                  System.out.print("\t["+this.poltronas[pos]+"]");
                  pos++;
                }
                System.out.println("\n");
            }
    }
  }
    
    // vai marcar "X"  para ocupado 
    public boolean ocuparPoltrona (int pos){
        if(this.poltronas[pos].equals("X")){
           System.out.println("\nATENÇÃO, POLTRONA JA OCUPADA!");
           return false;
        }else{
            this.cadVendidas += 1;
            this.cadDisponiveis = this.capacidade - this.cadVendidas;
            this.poltronas[pos] = "X";
        }
        return true;
    }
    
    public String toString() {
    	return "\n\nSala ["+numero+"] "+nomeSala
                      +"\n-----------------------------"
                      + "\n* Capacidade: "+capacidade
                      + "\n* Brinde: "+brinde            
                      + "\n* qtd Poltronas Disponiveis: "+cadDisponiveis
                      + "\n* qtd Poltronas Ocupadas: "+cadVendidas;
    }
    
    // Gets e Sets        
    public String[] getPoltronas(){
        return this.poltronas;
    }
     public String getNomeSala() {
    	return nomeSala;
    }
    public String getBrinde() {
    	return brinde;
    }
    public double getTaxa(){
    	return taxa;
    }          
    public int getNumero() {
		return numero;
    }
    public void setNumero(int numero) {
    	this.numero = numero;
    }
    public int getCapacidade() {
    	return capacidade;
    }
    public void setCapacidade(int capacidade) {
    	this.capacidade = capacidade;
    }
}
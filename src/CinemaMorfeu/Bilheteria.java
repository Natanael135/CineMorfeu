package CinemaMorfeu;

import java.util.Scanner;


	public class Bilheteria {
        
		private String[] formaPagamento = {"Pix","Dinheiro","Debito","Credito"};
		private double valorIngresso;
		Scanner ler = new Scanner( System.in );
         
		//Sistema para Imprimir Ingresso
		public double venderIngresso(BFilme filme, int quantidade){	

			ASala sala = filme.getSala();          
			int nSala=filme.getSala().getNumero();
			double valorTotal = 0.0;
			double valorBilhete = 0.0;
		
			if(quantidade > filme.getSala().getCapacidade()  ) {
				System.out.print("Capacidade da Sala excedida. ");			
			}
			else {
				sala.verPoltronas(nSala);
				for(int cont =1;cont<=quantidade;cont++){
					System.out.print(cont+"(a) Numero da poltrona : ");
					int pos = ler.nextInt();  
					System.out.print(
                	  "\n---Tipo de pagamento---"
                		+"\n | 1 - PIX             |"
                		+"\n | 2 - Dinheiro        |"
                        +"\n | 3 - Debito          |"
                        +"\n | 4 - Credito         |"
                        +"\n---------------------");
					System.out.print("\n | Opcao: ");
					int fpag = ler.nextInt();
					if(sala.ocuparPoltrona(pos)){
						valorBilhete = (this.valorIngresso + (this.valorIngresso * filme.getSala().getTaxa()));
						valorTotal += valorBilhete;
						this.imprimirBilhete(sala, pos, filme, valorBilhete,fpag);
					}    
				}    
			}
			return valorTotal;	
		}
		//Sistema para Imprimir bilhete
		private void imprimirBilhete(ASala sala,int pos, BFilme filme,double vb, int fpag){            
            System.out.println("-------- B I L H E T E --------");
            System.out.println("| SALA:"+ sala.getNomeSala()
                           + "\n| FILME:"+ filme.getNome()
                           + "\n| POLTRONA:"+ pos
                           + "\n| BRINDE:"+ sala.getBrinde()
                           + "\n| DURACAO:"+ filme.getDuracao()
                           + "\n| HORARIO: 22:30"
                           + "\n ----------------------------------"
                           + "\n| VALOR: "+vb
                           + "\n| FORMA DE PAGAMENTO: "+this.formaPagamento[fpag-1]);
        }
        //Gets e Sets
        public double getValorIngresso() {
    		return valorIngresso;
    	}
    	public void setValorIngresso(double valorIngresso) {
    		this.valorIngresso = valorIngresso;
    	}
}
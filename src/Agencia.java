import java.util.ArrayList;
import java.util.List;

public class Agencia {

   private String numero;
   private List<ContaEssencial> contasEssenciais = new ArrayList<>(); 
   private List<ContaRentavel> contasRentaveis = new ArrayList<>();
   private List<ContaTarifavel> contasTarifaveis = new ArrayList<>();

   public Agencia(String numero) {
      this.numero = numero;
   }

   public void addContaEssencial(ContaEssencial conta) {
      this.contasEssenciais.add(conta);
   }

   public void addContaRentavel(ContaRentavel conta){
      this.contasRentaveis.add(conta);
   }

   public void addContaTarifavel(ContaTarifavel conta){
      this.contasTarifaveis.add(conta);
   }

   public void saque(String numeroConta, double valor) throws ContaException {
      ContaEssencial conta = getConta(numeroConta);
      conta.saque(valor);   
   }

   public void deposito(String numeroConta, double valor) throws ContaException {
      ContaEssencial conta = getConta(numeroConta);
      conta.deposito(valor);
   }

   public void atualizaRendimentoContas(Double taxa){

      for(ContaRentavel contaRentavel: contasRentaveis){
         contaRentavel.atualizarRendimento(taxa);
      }
   }

   private ContaEssencial getConta(String numeroConta) throws ContaException{

      for(ContaEssencial contaEssencial: contasEssenciais){
         if(contaEssencial.getNumeroConta().equals(numeroConta)){
            return contaEssencial;
         }
      }

      // for(ContaRentavel contaRentavel: contasRentaveis){
      //    if(contaRentavel.getNumeroConta().equals(numeroConta)){
      //       return contaRentavel;
      //    }
      // }

      throw new ContaException("Numero da conta " + numeroConta + " não existe!");
   }    

}
     
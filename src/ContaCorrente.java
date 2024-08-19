public class ContaCorrente implements ContaTarifavel {

   private Agencia agencia;
   private String numeroConta;
   private double saldo;
   private double limiteChequeEspecial;
   private double taxa;

   public ContaCorrente(Agencia agencia, String numeroConta, double saldo, double limiteChequeEspecial) {
      this.agencia = agencia;
      this.numeroConta = numeroConta;
      this.saldo = saldo;
      this.limiteChequeEspecial = limiteChequeEspecial;
      this.taxa = 0.03;
   }
    
   @Override
   public void saque(Double valor) throws ContaException {
      if (valor > 0) {
         if (this.saldo + limiteChequeEspecial >= valor) {
            this.saldo -= valor;
         } else {
            throw new ContaException("Conta sem saldo suficiente: "+this.saldo);
         }
      } else {
            throw new ContaException("Valor inválido para saque "+valor);
      }
   }

   @Override
   public void deposito(Double valor) throws ContaException{
      if(valor > 0){
         this.saldo += valor;
      }else {
         throw new ContaException("Valor inválido para deposito: " + valor);
      }
   }

   @Override
   public String getNumeroConta(){
      return numeroConta;
   }


   @Override
   public void aplicaValorTarifa(){
      this.saldo = saldo - (1-taxa);
   }
}

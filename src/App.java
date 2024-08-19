public class App {
    public static void main(String[] args) throws Exception {

        Agencia agenciaX = new Agencia("1028-06");

        ContaTarifavel contaCorrente = new ContaCorrente(agenciaX, "1125-8", 500d, 900);
        ContaRentavel contaPoupanca = new ContaPoupanca(agenciaX, "2153-5", 1200d);
        ContaEssencial contaSalario = new ContaSalario(agenciaX, "2354-2", 2500d);

        agenciaX.addContaTarifavel(contaCorrente);
        agenciaX.addContaRentavel(contaPoupanca);
        agenciaX.addContaEssencial(contaSalario);

        agenciaX.saque("1125-8", 600d);
        agenciaX.saque("1125-8", 100d);
        agenciaX.saque("2153-5", 425d);
        agenciaX.saque("2354-2", 155d);

        agenciaX.deposito("1125-8", 1255d);
        agenciaX.deposito("2153-5", 300d);
        agenciaX.deposito("2153-5", -25d);
        agenciaX.deposito("2354-2", 150d);
        

        
    }
}

import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        //TODO: ler dados usando um objeto da classe Scanner
        //e exibi-los na tela do terminal

        Scanner scan = new Scanner(System.in);

        int id;
        String agencia;
        String nomeCliente;
        double saldo;

        System.out.println("Por favor, digite seu nome!");
        nomeCliente = scan.nextLine();
        System.out.println("Por favor, digite sua agencia!");
        agencia = scan.nextLine();
        System.out.println("Por favor, digite seu id!");
        id = scan.nextInt();
        System.out.println("Por favor, digite seu saldo!");
        saldo = scan.nextInt();

        System.out.println("Ola " + nomeCliente +
        ", obrigado por criar uma conta em nosso banco, sua agencia e "
        + agencia + ", conta " + id + " e seu saldo " + saldo
        +  " ja esta disponivel para saque");

        scan.close();
    }
}

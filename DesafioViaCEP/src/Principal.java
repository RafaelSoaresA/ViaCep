import java.io.IOException;
import java.util.Scanner;

public class Principal {
    static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        //Instância da classe ConsultaCep
        ConsultaCep consultaCep = new ConsultaCep();

        //Solicita ao usuário que digite o CEP que deseja consultar
        System.out.println("Digite o CEP que deseja consultar: ");
        var cep = entrada.nextLine();

        //Tenta buscar o endereço a partir do CEP digitado
        try{
            Endereco endereco = consultaCep.buscaEndereco(cep);
            System.out.println(endereco);
            GeradorDeArquivo geradorDeArquivo = new GeradorDeArquivo();
            geradorDeArquivo.gerarArquivo(endereco);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finalizando Aplicação");
        }
    }
}
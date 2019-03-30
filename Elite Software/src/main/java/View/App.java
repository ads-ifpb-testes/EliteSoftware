package View;

import Control.GastosDAO;
import Control.UsuarioDAO;
import Model.Gasto;
import Model.Usuario;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        boolean logged = false;
        Usuario usuariologado = null;
        Scanner sc = new Scanner(System.in);
        UsuarioDAO usuarios = new UsuarioDAO();
        GastosDAO gastos = new GastosDAO();

        while (true){
            while (!logged){

                int x = 0;
                System.out.println("1: Logar");
                System.out.println("2: Cadastrar");
                System.out.println("0: sair");
                x = sc.nextInt();
                if (x < 0 || x > 3){
                    System.out.println("Informe um número no escopo exibido");
                }

                switch (x){

                    case 0:
                        System.exit(0);

                    case 1:
                        String userlogin = null;
                        String senhalogin = null;
                        System.out.println("Informe seu username: ");
                        userlogin = sc.next();
                        System.out.println("Informe sua senha: ");
                        senhalogin = sc.next();
                        if (usuarios.isLogged(userlogin, senhalogin)){
                            logged = true;
                            usuariologado = usuarios.buscaUsuario(userlogin);
                        }
                        else {
                            System.out.println("Login incorreto");
                        }
                        break;


                    case 2:
                        try {
                            String newnome = "";
                            String newcpf = "";
                            String newsenha = "";
                            String newuser = "";
                            boolean newadmin = false;
                            System.out.println("Informe o nome: ");
                            newnome = sc.next();
                            System.out.println("Informe o cpf: ");
                            newcpf = sc.next();
                            System.out.println("Informe seu username: ");
                            newuser = sc.next();
                            System.out.println("Informe sua senha: ");
                            newsenha = sc.next();
                            System.out.println("É admin? (true ou false)");
                            newadmin = sc.nextBoolean();
                            usuarios.addUsuario(newnome, newcpf, newsenha, newuser, newadmin);
                            break;
                        }
                        catch (InputMismatchException e){
                            e.printStackTrace();
                            break;
                        }

                }
            }

            while (logged){

                int x = 0;
                System.out.println("1: Inserir gasto");
                System.out.println("2: Deletar gasto");
                System.out.println("3: Deletar conta");
                System.out.println("0: Voltar");
                x = sc.nextInt();

                switch (x){

                    case 0:
                        logged = false;
                        break;

                    case 1:
                        float newvalor = 0;
                        String newuser = null;
                        System.out.println("Informe o total do gasto: ");
                        newvalor = sc.nextFloat();
                        System.out.println("Informe seu username: ");
                        newuser = sc.next();
                        gastos.addGasto(newvalor, newuser);
                        break;

                    case 2:
                        System.out.println("Escolha o índice do gasto a ser excluido: ");
                        gastos.listarGastos();
                        x = sc.nextInt();
                        gastos.removeGasto(x-1);
                        break;

                    case 3:
                        System.out.println("Escolha o índice do usuário a ser excluido: ");
                        usuarios.listarUsuarios();
                        x = sc.nextInt();
                        usuarios.removeUsuario(x-1, usuariologado);
                        break;
                }

            }


        }
    }


}

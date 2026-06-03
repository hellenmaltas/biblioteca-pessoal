package account;

import java.util.Scanner;

public class UserService {
    Scanner scanner = new Scanner(System.in);

    public User cadastrar() {

        System.out.println("""
                   
        --------CADASTRO DA BIBLIOTECA--------
                
                """);

        while (true) {

            System.out.println("Digite o nome de usuário que deseja criar:");
            String nomeusuario = scanner.nextLine();

            System.out.println("Digita a senha do seu usuário: ");
            String senha = scanner.nextLine();

            boolean letraMaiuscula = false;
            boolean temNumero = false;
            boolean letraMinuscula = false;

            for (int i = 0; i < senha.length(); i++) {
                char c = senha.charAt(i);

                if (Character.isUpperCase(c)) {
                    letraMaiuscula = true;
                }

                if (Character.isLowerCase(c)) {
                    letraMinuscula = true;
                }

                if (Character.isDigit(c)) {
                    temNumero = true;
                }

            }

            if (nomeusuario.length() <= 9 && senha.length() <= 9 && letraMaiuscula && letraMinuscula && temNumero) {
                System.out.println("""
                        Carregando....
                        
                        
                        --------CADASTRO REALIZADO--------
                        
                        
                        Sua conta foi criada com sucesso.
                        """);
                return new User(nomeusuario, senha);
            }

            System.out.println("""
                     Usuário ou senha inválidos!
                    
                     Usuário:
                     • Até 9 caracteres.
                    
                     Senha:
                     • Até 9 caracteres.
                     • Pelo menos 1 letra maiúscula.
                     • Pelo menos 1 letra minúscula.
                     • Pelo menos 1 número.
                    
                     Tente novamente.
                    """);
        }
    }
}




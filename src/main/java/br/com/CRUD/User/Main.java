package br.com.CRUD.User;

import br.com.CRUD.User.dao.UserDAO;
import br.com.CRUD.User.excpetion.EmptyStorageException;
import br.com.CRUD.User.excpetion.UserNotFoundException;
import br.com.CRUD.User.excpetion.ValidatorException;
import br.com.CRUD.User.model.MenuOption;
import br.com.CRUD.User.model.UserModel;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static br.com.CRUD.User.validator.UserValidator.verifyModel;

public class Main {
    private final static UserDAO dao = new UserDAO();

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        while (true){
            System.out.println("""
                Bem vindo ao sistema de usuários, digite o número da opção desejada:
                1- Cadastrar
                2- Atualizar
                3- Excluir
                4- Buscar por identificador
                5- Listar
                6- Sair
                """);

            var opcaoUserSelecionada = scanner.nextInt();
            var opcaoSelecionada = MenuOption.values()[opcaoUserSelecionada - 1];
            switch (opcaoSelecionada){
                case SAVE -> {
                    try {
                        var user = requestToSave();
                        dao.save(user);
                        System.out.printf("Usuário cadastrado %s com sucesso!", user);
                    } catch (ValidatorException | EmptyStorageException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case UPDATE ->{
                    try {
                        dao.update(requestToUpdate());
                    } catch (ValidatorException ex){
                        System.out.println(ex.getMessage());
                        ex.printStackTrace();
                    }
                }
                case DELETE -> dao.delete(requestId());
                case FIND_BY_ID ->{
                    try {
                        var id = requestId();
                        var user = dao.findById(id);
                        System.out.printf("Usuário com %s cadastrado \n%s", id, user);
                    }catch (UserNotFoundException | EmptyStorageException e){
                        System.out.printf(e.getMessage());

                    }finally {
                        System.out.printf("ele vai mostrar independente onde cair no try ou catch");
                    }

                }
                case FIND_ALL -> {
                    var users = dao.findAll();
                    System.out.println("Usuários cadastrados:");
                    users.forEach(System.out::println);
                }
                case EXIT -> {
                    System.exit(0);
                }
            }
        }


    }

    private static long requestId() {
        System.out.println("Informe o seu id");
        return scanner.nextLong();
    }

    private static UserModel requestToSave() throws ValidatorException {
        System.out.println("Informe o seu nome");
        String nome = scanner.next();
        System.out.println("Informe o seu e-mail");
        String email = scanner.next();
        System.out.println("Informe a data de aniversário (dd/MM/yyyy)");
        String dataDeAniversario = scanner.next();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var aniversarioFormatada = LocalDate.parse(dataDeAniversario, formatter);
        return validateInput(0, nome, email, aniversarioFormatada);

    }

    private static UserModel validateInput(final long id, final String nome, final String email, final LocalDate dataDeAniversario)
            throws ValidatorException {
        var user = new UserModel(0, nome, email, dataDeAniversario);
        verifyModel(user);
        return user;

    }

    private static UserModel requestToUpdate() throws ValidatorException {
        System.out.println("Informe o seu nome");
        String nome = scanner.next();
        System.out.println("Informe o seu e-mail");
        String email = scanner.next();
        System.out.println("Informe a data de aniversário (dd/MM/yyyy)");
        String dataDeAniversario = scanner.next();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var aniversarioFormatada = LocalDate.parse(dataDeAniversario, formatter);
        return validateInput(0,nome,email,aniversarioFormatada);
    }
}

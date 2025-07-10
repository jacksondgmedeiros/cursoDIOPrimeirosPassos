package br.com.CRUD.User.validator;

import br.com.CRUD.User.excpetion.ValidatorException;
import br.com.CRUD.User.model.UserModel;

public class UserValidator {
    public UserValidator() {
    }

    public static void verifyModel(final UserModel model) throws ValidatorException {
        if (stringIsBlank(model.getUsername()))
            throw new ValidatorException("Informe um nome válido");

        if ( model.getUsername().length() < 1) throw new ValidatorException("O nome tem que ter mais de um caracter");

        if (stringIsBlank(model.getEmail())) throw new ValidatorException("Informe um e-mail válido");
    }

    private static boolean stringIsBlank(final String str) {
        return str == null || str.isBlank() ;
    }
}

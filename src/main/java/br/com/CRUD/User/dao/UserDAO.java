package br.com.CRUD.User.dao;

import br.com.CRUD.User.excpetion.EmptyStorageException;
import br.com.CRUD.User.excpetion.UserNotFoundException;
import br.com.CRUD.User.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private long nextId = 1;

//    lista de userModel
    private List<UserModel> models = new ArrayList<UserModel>();

    public UserModel save(final UserModel model) {
        model.setId(nextId++);
        models.add(model);
        return model;
    }

    public UserModel update(final UserModel model) {
        var toUpdate = findById(model.getId());
        models.remove(toUpdate);
        models.add(model);
        return model;
    }

    public UserModel findById(final long id) {
        verifyStorage();
        var message = "Não existe usuário com o id " + id + " cadastrado";
        return models.stream()
                .filter(model -> model.getId() == id)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(message));
    }
    public void delete(final long id) {
        var toDelete = findById(id);
        models.remove(toDelete);

    }

    public List<UserModel> findAll() {
        List<UserModel> result;
        try {
            verifyStorage();
            result = models;
        }catch (EmptyStorageException e) {
            e.printStackTrace();
            result = new ArrayList<>();
        }
        return result;
    }

    private void verifyStorage(){
        if (models.isEmpty()) throw new EmptyStorageException("O armazenamento está vazio");
    }
}

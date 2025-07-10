package br.com.CRUD.User.excpetion;

public class EmptyStorageException extends RuntimeException {
    public EmptyStorageException(String message) {
        super(message);
    }
}

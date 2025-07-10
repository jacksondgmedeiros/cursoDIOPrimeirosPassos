package br.com.CRUD.User.model;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Objects;

public class UserModel{
        private long id;
        private String username;
        private String email;
        private LocalDate aniversario;

    public UserModel() {
    }

    public UserModel(long id, String username, String email, final LocalDate aniversario) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.aniversario = aniversario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return id == userModel.id && Objects.equals(username, userModel.username) && Objects.equals(email, userModel.email) && Objects.equals(aniversario, userModel.aniversario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, aniversario);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", aniversario=" + aniversario +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getAniversario() {
        return aniversario;
    }

    public void setAniversario(LocalDate aniversario) {
        this.aniversario = aniversario;
    }
}

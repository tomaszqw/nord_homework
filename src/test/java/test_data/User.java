package test_data;

public record User(String login, String password) {
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}

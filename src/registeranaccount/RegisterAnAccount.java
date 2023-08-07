package registeranaccount;

public class RegisterAnAccount {
    private  String account ;
    private  String password;
    private String email ;
    private  String numberPhone;
    private String Address;

    public RegisterAnAccount() {

    }

    public RegisterAnAccount(String account, String password, String email, String numberPhone, String address) {
        this.account = account;
        this.password = password;
        this.email = email;
        this.numberPhone = numberPhone;
        Address = address;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "RegisterAnAccount{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}

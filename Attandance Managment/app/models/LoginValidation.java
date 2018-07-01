package models;

import play.data.validation.Constraints;

import javax.validation.Constraint;


public class LoginValidation {

    public LoginValidation(){
    }

    public LoginValidation(String uname ,String psw){
        this.uname=uname;
        this.psw=psw;
    }

    @Constraints.Required
    @Constraints.MinLength(5)
    @Constraints.MaxLength(15)
    private String uname;

    @Constraints.Required
    @Constraints.MinLength(8)
    @Constraints.MaxLength(15)
    private String psw;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }
}

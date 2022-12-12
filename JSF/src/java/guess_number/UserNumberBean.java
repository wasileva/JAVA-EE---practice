package guess_number;

import java.io.Serializable;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="userNumberBean")
@SessionScoped
public class UserNumberBean implements Serializable {

    private Integer randomNumber;
    private Integer userNumber;
    
    public UserNumberBean() {
        randomNumber = new Random().nextInt(11);
        System.out.println("Random number is " + randomNumber);
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }

    public Integer getUserNumber() {
        return userNumber;
    }

    public String getResponse() {
        if ((userNumber != null) && (userNumber.equals(randomNumber))) {
             randomNumber = new Random().nextInt(11);
             System.out.println("My new number is " + randomNumber);
             return "Good guess!!! Try again!";
        }
        return "Sorry. " + userNumber + " is a wrong number. Please try again";
    }
}

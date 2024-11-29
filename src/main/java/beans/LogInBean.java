/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;

/**
 *
 * @author zahidcolin
 */
@Named(value = "logInBean")
@RequestScoped
public class LogInBean implements Serializable{
    private String username;
    private String password;
    private String confirmPassword;
   
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
    
    public String checkPassword() {
        if (password != null && password.equals(confirmPassword)) {
            // Passwords match, perform login or redirect
            return "page1";  // Navigate to the next page (or perform the desired action)
        } else {
            // Passwords do not match, show error message
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Passwords do not match :("));
            return null;  // Stay on the current page and show the error
        }
    }
}

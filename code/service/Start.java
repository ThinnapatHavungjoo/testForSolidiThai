package service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class Start {
    public static void main(String[] data) {
        var context = SpringApplication.run (Setup.class);
    }
}

@SpringBootApplication
class Setup {
    String source = "jdbc:mysql://127.0.0.1/memberdb?"
            + "user=adminmember&password=admin123";
    @Bean
    DriverManagerDataSource connect() {
        return new DriverManagerDataSource(source);
    }
}

@Table ("memberInfo")
class MemberInfo {
    @Id private int id;
    private String firstName;
    private String lastName;
    private String email;
    
    public MemberInfo() {}
    
    public MemberInfo(String firstName, String lastName, char gender, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
    public void setId(int id) {
        this.id = id;
    }
        
    public int getId() {
        return this.id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName.substring(0, 1).toUpperCase() + 
                firstName.substring(1).toLowerCase();
    }
        
    public String getFirstName() {
        return firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName.substring(0, 1).toUpperCase() +
                lastName.substring(1).toLowerCase();
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        
    public String getEmail() {
        return email;
    }
}
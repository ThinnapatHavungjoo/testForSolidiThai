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

@Table ("member_info")
class Member_info {
    @Id private int id;
    private String first_name;
    private String last_name;
    private char gender;
    private String email;
    
    public Member_info() {}
    
    public Member_info(String first_name, String last_name, char gender, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.email = email;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public void setFirst_name(String first_name) {
        this.first_name = first_name.substring(0, 1).toUpperCase() + 
                first_name.substring(1).toLowerCase();
    }
        
    public String getFirst_name() {
        return first_name;
    }
    
    public void setLast_name(String last_name) {
        this.last_name = last_name.substring(0, 1).toUpperCase() +
                last_name.substring(1).toLowerCase();
    }
    
    public String getLast_name() {
        return last_name;
    }
    
    public void setGender(char gender) {
        if (gender == 'M') {this.gender = 'M';}
        if (gender == 'F') {this.gender = 'F';}
        if (gender == 'O') {this.gender = 'O';}
    }
        
    public char getGender() {
        return gender;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
        
    public String getEmail() {
        return email;
    }
}
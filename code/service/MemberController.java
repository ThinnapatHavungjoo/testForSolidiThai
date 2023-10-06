package service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MemberController {
    @GetMapping("/get/users")
    Iterable get() {
        return memberRepository.findAll();
    }
    
    @GetMapping("/get/users/id")
    Optional showById(int id){
        return memberRepository.findById(id);
    }
    
    @RequestMapping("/post/users")
    public String addUsers(String first_name, String last_name, char gender, 
            String email) {
                Member_info addMember = new Member_info();
                addMember.setFirst_name(first_name);
                addMember.setLast_name(last_name);
                addMember.setGender(gender);
                addMember.setEmail(email);
                memberRepository.save(addMember);
                return "Success";
    }
    
    @DeleteMapping ("delete/users/id")
    String deleteById(int id) {
        memberRepository.deleteById(id);
        return "Success";
    }
    
    @Autowired MemberRepository memberRepository;
}
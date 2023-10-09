package service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MemberController {
    @RequestMapping("/get/users")
    Iterable get() {
        return memberRepository.findAll();
    }
    
    @RequestMapping("/get/users/id")
    Optional showById(int id){
        return memberRepository.findById(id);
    }

    @RequestMapping("/post/users")
    MemberInfo newMeberInfo(@RequestBody MemberInfo newMemberInfo) {
        return memberRepository.save(newMemberInfo);
    }
    
    @RequestMapping("/post/users/{id}")
    MemberInfo updateMemberInfo(@RequestBody MemberInfo newMemberInfo, 
            @PathVariable int id) {
        return memberRepository.findById(id)
                .map(memberInfo -> {
                    memberInfo.setFirstName(newMemberInfo.getFirstName());
                    memberInfo.setLastName(newMemberInfo.getLastName());
                    memberInfo.setEmail(newMemberInfo.getEmail());
                    return memberRepository.save(memberInfo);
                })
                .orElseGet(() -> {
                    newMemberInfo.setId(id);
                    return memberRepository.save(newMemberInfo);
                });
    }

    
    @RequestMapping ("delete/users/id")
    String deleteById(int id) {
        memberRepository.deleteById(id);
        return "Success";
    }
    
    @Autowired MemberRepository memberRepository;
}
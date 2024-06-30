
package com.igrowker.cvinter.service;

import cvinter.igrowker.model.entity.User;
import java.util.List;

public interface IRecruiterService {

 List<User> getRecruitedUsersByRecruiterId(String recruiterId);
 User findAll();


    
}

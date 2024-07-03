
package com.igrowker.cvinter.service;

import com.igrowker.cvinter.model.dto.UserDTO;
import com.igrowker.cvinter.model.entity.User;
import java.util.List;

public interface IRecruiterService {

    public List<UserDTO> getCandidates();
}

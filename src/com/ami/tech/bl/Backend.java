package com.ami.tech.bl;

import com.ami.tech.dl.dao.*;
import com.ami.tech.dl.dto.*;
import com.ami.tech.dl.exceptions.*;
import com.ami.tech.dl.interfaces.dao.*;
import com.ami.tech.dl.interfaces.dto.*;

public class Backend {

  DTOInterface user;

  public int backendLogin(String id, String password) {
    
    
    if (id.length() == 0 || password.length() == 0) {
      return -1;
    }
    boolean valid=false;
    
    DAOInterface dao;
    dao = new DAOBank();

    user = dao.loginValidity();

    return 0;
  }
}

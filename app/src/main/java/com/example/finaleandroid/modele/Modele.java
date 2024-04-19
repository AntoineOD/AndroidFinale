package com.example.finaleandroid.modele;

import com.example.finaleandroid.modele.entite.Code;

import java.util.ArrayList;
import java.util.List;

public class Modele {

   private List<Code> codeList = new ArrayList<>() ;

  public List<Code> getCodes() {
      return codeList;
   }
   public void setCodes(List<Code> codeList) {
      this.codeList = codeList;
   }
   public Code getCode(String id) {
      for (Code code:this.codeList)
         if (code.getId().equals(id))
            return code;
      return null;
   }
}

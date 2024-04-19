package com.example.finaleandroid.modele;

import com.example.finaleandroid.modele.entite.Code;
import com.example.finaleandroid.modele.entite.Couleur;
import com.example.finaleandroid.modele.entite.Stat;

import java.util.ArrayList;
import java.util.List;

public class Modele {

   private List<Code> codeList = new ArrayList<>() ;
    private List<Stat> statList = new ArrayList<>() ;
    private List<Couleur> couleurList = new ArrayList<>() ;

  public List<Code> getCodes() {
      return codeList;
   }
   public List<Stat> getStats() {
      return statList;
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
   public void setStats(List<Stat> statList) {
      this.statList = statList;
   }
   public Stat getStat(String id) {
      for (Stat stat:this.statList)
         if (stat.getId().equals(id))
            return stat;
      return null;
   }

    public List<Couleur> getCouleurs() {
      return couleurList;
    }

    public Couleur getCouleur(String id) {
        for (Couleur couleur:this.couleurList)
            if (couleur.getCouleur().equals(id))
                return couleur;
        return null;
    }
    public void setCouleurs(List<Couleur> couleurList) {
      this.couleurList = couleurList;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Models.Categories;
import Models.Items;
import Models.Users;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author 709488
 */
public class CategoryDB {
     public List<Categories> getAll() throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
           Query query = em.createNamedQuery("Categories.findAll");
            List<Categories> list = query.getResultList();
            return list;
        }
        finally {
        em.close();
        }
    }
     public Categories get(int catID){
         EntityManager em = DBUtil.getEmFactory().createEntityManager();
         try {
             Categories category = em.find(Categories.class, catID);
             return category;
         }
         finally {
             em.close();
         }
         
     
     }
    
}


package DataAccess;

import Models.Items;
import Models.Users;
import java.util.List;
import javax.persistence.EntityManager;


public class UserDB {
    public Users get(String username ){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Users user = em.find(Users.class, username);
            return user;
        }
        finally {
            em.close();
        }
    }
    public Users getPassword(String password){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            Users user = em.find(Users.class, password);
            return user;
            
        }finally {
            em.close();
        }
    }
    public String checkName(String username) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {Users user = em.find(Users.class, username);
            return user.getUsername();
            
        }
        finally {
            em.close();
        }
    }
     public String checkPassword(String password) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {Users user = em.find(Users.class, password);
            return user.getPassword();
            
        }
        finally {
            em.close();
        }
    }
}

package com.dao;

import com.model.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ItemDAO {
   @PersistenceContext
   private EntityManager entityManager;

   public Item save(Item item) throws Exception{
       checkItem(item);
       entityManager.persist(item);
       return item;
   }

   public Item findById(long id){
       return entityManager.find(Item.class, id);
   }

   public Item update(Item item) throws Exception{
       checkItem(item);
       entityManager.merge(item);
       return item;
   }

   public void delete(long id){
       Item item = entityManager.find(Item.class, id);
       entityManager.remove(item);
   }

    private static void checkItem(Item item)throws Exception{
        if(item == null){
            throw new Exception("Exception in method ItemDAO.checkItem. Item can't be null.");
        }
    }
}

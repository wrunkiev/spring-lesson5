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

   public Item save(Item item){
       entityManager.persist(item);
       return item;
   }

}

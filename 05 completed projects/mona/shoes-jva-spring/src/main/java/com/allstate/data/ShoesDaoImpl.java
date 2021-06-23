package com.allstate.data;

import com.allstate.domain.Shoes;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional(Transactional.TxType.REQUIRED)
public class ShoesDaoImpl implements ShoesDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Shoes> getShoesBySizeDao(Integer Size) {

        Query query = em.createQuery("SELECT s FROM Shoes s WHERE s.size = " + Size);
        //*Add query here
        return query.getResultList();
    }

   @Override
   public List<Shoes> getShoesByPriceDao(Double Price) {
      Query query = em.createQuery("SELECT s FROM Shoes s WHERE s.price = " + Price);

    return query.getResultList();
    }
}

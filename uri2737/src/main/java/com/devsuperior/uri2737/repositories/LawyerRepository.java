package com.devsuperior.uri2737.repositories;

import com.devsuperior.uri2737.entities.Lawyer;
import com.devsuperior.uri2737.projections.LawyerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {

    /*Devido ser uma consulta SQL nativa e o nosso Projection estar em camelCase getCustomersNumber();
     * Devemos dar um apelido para o customers_number, ou seja, customers_number AS customersNumber, se não retorna null
     * Só precisa colocar na primeira parte da UNIÃO, no resto é OPCIONAL*/
    @Query(nativeQuery = true, value = "(SELECT name, customers_number AS customersNumber " +
            "FROM lawyers " +
            "WHERE customers_number = ( " +
            " SELECT MAX(customers_number) " +
            " FROM lawyers ))" +
            "UNION ALL " +
            "(SELECT name, customers_number " +
            "FROM lawyers " +
            "WHERE customers_number = ( " +
            " SELECT MIN(customers_number) " +
            " FROM lawyers )) " +
            "UNION ALL " +
            "(SELECT 'Average', ROUND(AVG(customers_number), 0) " +
            "FROM lawyers)")
    public List<LawyerMinProjection> search();

    /*A JPQL não tem união, até daria para fazer uma consulta equivalente, mas não valeria o esforço*/

}

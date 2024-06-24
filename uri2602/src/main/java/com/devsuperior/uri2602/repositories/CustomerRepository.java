package com.devsuperior.uri2602.repositories;

import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /*nativeQuery = true é pra ser SQL raíz a consulta
     * :state é para usar a String state recebida :<nome_argumento>

     * Quando fazemos uma consulta no repository retornando a interface, o próprio Spring Data JPA cria um objeto CONCRETO com a estrutura da interface,
     * então poderiamos chamar o .getName() do objeto
     *
     * IMPORTANTE: quando a consulta é nativa, o Spring Data JPA não sabe como mepear os resultados da consulta nativa diretamente para o DTO.
     * A criação de objetos DTO é só suportada em JPQL*/
    @Query(nativeQuery = true, value = "SELECT name " +
            "FROM customers " +
            "WHERE UPPER(state) = UPPER(:state)")
    List<CustomerMinProjection> search1(String state);

    /*A consulta JPQL não precisa da projection, podemos retornar o DTO direto
     *
     * Pra fazer projeção, ao invés de só colocar SELECT obj, tem que colocar o caminho completo do DTO depois de um new*/
    @Query(value = "SELECT new com.devsuperior.uri2602.dto.CustomerMinDTO(obj.name) " +
            "FROM Customer obj " +
            "WHERE UPPER(obj.state) = UPPER(:state)")
    List<CustomerMinDTO> search2(String state);
}

package com.devsuperior.uri2602.projections;

/*Uma forma de acessar o banco de dados somente nos campos que precisamos é definir uma projeção
 * Projeção é uma interface que vai ter somente aqueles campos que você precisa*/
public interface CustomerMinProjection {

    /*Colocamos o nome dos campos que quisermos nas formas dos métodos GET.
     * Aqui, queremos somente o nome dos usuários (coluna name no BD e atributo name na classe)*/
    String getName();

}

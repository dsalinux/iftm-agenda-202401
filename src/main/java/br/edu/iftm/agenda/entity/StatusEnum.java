/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.iftm.agenda.entity;

/**
 *
 * @author danilo
 */
public enum StatusEnum {
    
    CRIADO("Criado"),
    EM_ATENDIMENTO("Em atendimento"),
    PAUSADO("Pausado"),
    AGUARDANDO_RESPOSTA("Aguardando resposta"),
    CONCLUIDO("Concluído");
    
    private String nome;
    
    private StatusEnum(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
}

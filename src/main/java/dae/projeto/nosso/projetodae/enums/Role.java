package dae.projeto.nosso.projetodae.enums;

public enum Role {

    /**
     * Colaborador: Investigadores, programadores, estudantes
     * Podem fazer upload, comentar, rating, subscrever tags
     */

    CONTRIBUTOR,

    /**
     * Responsável: Investigadores sénior, coordenadores
     * Podem criar/remover tags, ocultar comentários e publicações
     */

    MANAGER,

    /**
     * Administrador: Gestores do sistema
     * Podem gerir utilizadores, alterar roles, consultar todo o histórico
     */

    ADMIN
}

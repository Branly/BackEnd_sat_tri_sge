/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.constants;

/**
 *
 * @author abaestrad
 */
public enum Message {
    
    UNKNOWN_USER("No se permite el acceso de usuarios desconocidos"),
    NO_ROLE_USER("No tiene el rol requerido para realizar la operación"),
    NO_PROFILE_USER("No tiene el perfil requerido para realizar la operación"),
    INVALID_PARAMS("La petición tiene parámetros inválidos"),
    UNKNOWN_ERROR("Error interno del sistema"),
    GROUP_NOT_FOUND("El grupo \"%d\" no existe"),
    COLLABORATOR_NOT_FOUND("El NIT no pertenece a un colaborador registrado"),
    OPERATOR_ALREADY_IN_GROUP("El operador ya existe en otro grupo de trabajo. Por favor, verifique."),
    OPERATORS_ALREADY_IN_GROUP("Los siguientes operadores ya existe en otro grupo de trabajo. Por favor, verifique."),
    PROFILES_NOT_FOUND("No se encontraron perfiles para NIT ingresados"),
    ROLE_NOT_FOUND("No posee el rol requerido"),
    OPERATOR_ONCE_PER_GROUP("El operador únicamente puede pertenecer a un grupo de trabajo");

    private final String text;

    private Message(String text) {
        this.text = text;
    }

    public String getText(Object... params) {
        return String.format(this.text, params);
    }
    
}

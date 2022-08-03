/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 *
 * @author abaestrad
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Role {
    
    public static final String ADMINISTRADOR = "AdministrativoSIPFAdministrador";
    public static final String AUTORIZADOR = "AdministrativoSIPFAutorizador";
    public static final String APROVADOR = "AdministrativoSIPFAprovador";
    public static final String VERIFICADOR = "AdministrativoSIPFVerificador";
    public static final String OPERADOR = "AdministrativoSIPFOperador";
    public static final String SOLICITANTE = "AdministrativoSIPFSolicitante";

    public static final List<String> LIST;

    static {
        String[] roles = {ADMINISTRADOR, AUTORIZADOR, APROVADOR, VERIFICADOR, OPERADOR, SOLICITANTE};
        LIST = Collections.unmodifiableList(Arrays.asList(roles));
    }
    
}

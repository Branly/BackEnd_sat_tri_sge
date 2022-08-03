/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.dtos;

import gt.gob.sat.sat_tri_sge.constants.Role;
import gt.gob.sat.sat_tri_sge.projections.OpcionMenuProjection;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toSet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author abaestrad
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLogged {
 
    private String login;
    private String nit;
    private String ip;
    private List<String> roles;
    private String name;
    private List<AllowedUriDto> allowedUris;
    private Date loggedSince;
    private List<OpcionMenuProjection> options;

    public static UserLogged createDefault() {
        return UserLogged.builder()
                .login("localtest")
                .nit("localtest")
                .name("localtest")
                .ip("127.0.0.1")
                .roles(Arrays.asList("AdministrativoSGETAdministrador"))
                .loggedSince(new Date())
                .allowedUris(Arrays.asList(
                        new AllowedUriDto("*", Arrays.asList("*"))
                )).build();
    }

    public List<String> matchedRoles() {
        return matchedRoles(this.roles);
    }

    public static List<String> matchedRoles(List<String> roles) {
        return roles.stream()
                .map(role -> role.replaceAll("\\s|\\[|\\]", ""))
                .filter(Role.LIST.stream().collect(toSet())::contains)
                .collect(Collectors.toList());
    }

    public boolean constainsRole() {
        return matchedRoles().size() > 0;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.sat.sat_tri_sge.services;

import gt.gob.sat.sat_tri_sge.Config;
import gt.gob.sat.sat_tri_sge.Utils.HeaderUtils;
import javax.annotation.Nullable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author crist
 */
@Service
@Slf4j
public class ConsumosService {
//    private final Config config;
//
//    public ConsumosService(Config config) {
//        this.config = config;
//    }
//
//    /**
//     * Método encargado de consumir un servicio y retornar la respuesta del
//     * mismo.
//     *
//     * @param <T>
//     * @param body Objeto del cuerpo de la peticion (Puede ser nulo en caso de
//     * no necesitarse).
//     * @param url Ruta del metodo a consumir.
//     * @param klass Clase para dar tipo a la respuesta que retorna el ws.
//     * @param type Tipo de peticion HTTP a realizar.
//     *
//     * @return Respuesta del ws en base al tipo recibido.
//     */
//    public <T> T consume(@Nullable Object body, @NotNull @NotBlank String url, @NotNull Class<T> klass, @NotNull HttpMethod type) {
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = HeaderUtils.createHeaders();
//        String ruta = config.getPingUrlInterna() + url;
//        log.info("la linea 52: " + ruta);
//        HttpEntity<?> requestBody = new HttpEntity<>(body, headers);
//        return restTemplate.exchange(ruta, type, requestBody, klass).getBody();
//    }
//
//    /**
//     * Método encargado de consumir un servicio y retornar la respuesta del
//     * mismo.
//     *
//     * @param <T>
//     * @param body Objeto del cuerpo de la peticion (Puede ser nulo en caso de
//     * no necesitarse).
//     * @param url Ruta del metodo a consumir.
//     * @param klass Clase para dar tipo a la respuesta que retorna el ws.
//     * @param type Tipo de peticion HTTP a realizar.
//     *
//     * @return Respuesta del ws en base al tipo recibido.
//     */
//    public <T> T consume(@Nullable Object body, @NotNull @NotBlank String url, @NotNull ParameterizedTypeReference<T> klass, @NotNull HttpMethod type) {
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = HeaderUtils.createHeaders();
//        String ruta = config.getPingUrlInterna() + url;
//        log.info(ruta);
//        HttpEntity<?> requestBody = new HttpEntity<>(body, headers);
//        return restTemplate.exchange(ruta, type, requestBody, klass).getBody();
//    }
//
//    /**
//     * Método encargado de consumir un servicio y retornar la respuesta del
//     * mismo.
//     *
//     * @param <T>
//     * @param body Objeto del cuerpo de la peticion (Puede ser nulo en caso de
//     * no necesitarse).
//     * @param url Ruta del metodo a consumir.
//     * @param klass Clase para dar tipo a la respuesta que retorna el ws.
//     * @param type Tipo de peticion HTTP a realizar.
//     * @param headers Encabezados de la petición.
//     *
//     * @return Respuesta del ws en base al tipo recibido.
//     */
//    public <T> T consume(@Nullable Object body, @NotNull @NotBlank String url, @NotNull Class<T> klass, @NotNull HttpMethod type, HttpHeaders headers) {
//        RestTemplate restTemplate = new RestTemplate();
//        String ruta = config.getPingUrlInterna() + url;
//        System.out.println(type.name() + ": " + ruta);
//        HttpEntity<?> requestBody = new HttpEntity<>(body, headers);
//        return restTemplate.exchange(ruta, type, requestBody, klass).getBody();
//    }
//
//    /**
//     * Método encargado de consumir un servicio y retornar la respuesta del
//     * mismo.
//     *
//     * @param <T>
//     * @param body Objeto del cuerpo de la peticion (Puede ser nulo en caso de
//     * no necesitarse).
//     * @param url Ruta del metodo a consumir.
//     * @param klass Clase para dar tipo a la respuesta que retorna el ws.
//     * @param type Tipo de peticion HTTP a realizar.
//     * @param headers Encabezados de la petición.
//     *
//     * @return Respuesta del ws en base al tipo recibido.
//     */
//    public <T> T consumeCompleteUrlOracle(@Nullable Object body, @NotNull @NotBlank String method, @NotNull Class<T> klass, @NotNull HttpMethod type) {
//
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = HeaderUtils.createHeaders(config.getUsrWebServiceOracle(), config.getPassWebServiceOracle());
//        String url = config.getPingUrlWsOracle() + method;
//        HttpEntity<?> requestBody = new HttpEntity<>(body, headers);
//        return restTemplate.exchange(url, type, requestBody, klass).getBody();
//    }
//
//    /**
//     * Método encargado de consumir un servicio y retornar la respuesta del
//     * mismo.
//     *
//     * @param <T>
//     * @param body Objeto del cuerpo de la peticion (Puede ser nulo en caso de
//     * no necesitarse).
//     * @param url Ruta del metodo a consumir.
//     * @param klass Clase para dar tipo a la respuesta que retorna el ws.
//     * @param type Tipo de peticion HTTP a realizar.
//     * @param headers Encabezados de la petición.
//     *
//     * @return Respuesta del ws en base al tipo recibido.
//     */
//    public <T> T consume(@Nullable Object body, @NotNull @NotBlank String url, @NotNull ParameterizedTypeReference<T> klass, @NotNull HttpMethod type, HttpHeaders headers) {
//        RestTemplate restTemplate = new RestTemplate();
//        String ruta = config.getPingUrlInterna() + url;
//        HttpEntity<?> requestBody = new HttpEntity<>(body, headers);
//        return restTemplate.exchange(ruta, type, requestBody, klass).getBody();
//    }
//    
//     public <T> T consumeCompleteUrlSqlServer(@Nullable Object body, @NotNull @NotBlank String url, @NotNull Class<T> klass, @NotNull HttpMethod type) {
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = HeaderUtils.createHeaders(config.getUsrWebServiceProsis(), config.getPassWebServiceProsis());
//        String ruta = config.getPingUrlWsSqlServer() + url;
//        System.out.println(type.name() + ": " + ruta);
//        HttpEntity<?> requestBody = new HttpEntity<>(body, headers);
//        return restTemplate.exchange(ruta, type, requestBody, klass).getBody();
//    }
//
//    public String getAppId(Integer id) {
//        String processId="";
//       switch (id) {
//           case 1:
//             processId= config.getIdProcesoInsumo();
//             break;
//           case 2:
//             processId = config.getIdProcesoCaso();
//             break;
//       }
//       return processId;
//    }
}

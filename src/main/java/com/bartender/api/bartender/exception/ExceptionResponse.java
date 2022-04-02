package com.bartender.api.bartender.exception;


import java.util.Map;

public class ExceptionResponse {

    private String mensaje;

    private Map<String, String> erroresValidacion;

    public ExceptionResponse(String mensaje) {
        this.mensaje = mensaje;
    }

    public ExceptionResponse(String mensaje, Map<String, String> erroresValidacion) {
        this.mensaje = mensaje;
        this.erroresValidacion = erroresValidacion;
    }

    public ExceptionResponse() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Map<String, String> getErroresValidacion() {
        return erroresValidacion;
    }

    public void setErroresValidacion(Map<String, String> erroresValidacion) {
        this.erroresValidacion = erroresValidacion;
    }

}

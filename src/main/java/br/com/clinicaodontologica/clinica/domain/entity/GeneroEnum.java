package br.com.clinicaodontologica.clinica.domain.entity;

public enum GeneroEnum {
    M("masculino"),
    F("feminino");
    private String genero;

    GeneroEnum (String genero){
        this.genero =genero;
    }
    public String getGenero(){
        return genero;
    }
}

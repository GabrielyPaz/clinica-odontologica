package br.com.clinicaodontologica.clinica.api.dto.response.wrapperResponse;

import br.com.clinicaodontologica.clinica.api.dto.response.listResponse.ClinicaListResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClinicaWrapperResponse {
    private List<ClinicaListResponse> clinicas;
}

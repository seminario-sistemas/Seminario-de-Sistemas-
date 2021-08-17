package edu.uspg.service;

import edu.uspg.dto.AsignacionLibroDTO;
import edu.uspg.model.Asignacion;

public interface IAsignacionService extends ICRUD<Asignacion> {

	Asignacion registrarTransaccional(AsignacionLibroDTO dto);
}

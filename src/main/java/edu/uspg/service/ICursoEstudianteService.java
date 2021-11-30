package edu.uspg.service;

import java.util.List;

import edu.uspg.model.CursoEstudiante;
import edu.uspg.model.EstudianteConsulta;
import edu.uspg.model.PorcentajeAsistencia;


public interface ICursoEstudianteService {
	List<CursoEstudiante> clasesEstudiante(Integer id);
	List<CursoEstudiante> clasesCatedratico(Integer id);
	List<CursoEstudiante> clasesEstudianteManana(Integer id, Integer diaSemana);
	List<CursoEstudiante> clasesCatedraticoManana(Integer id, Integer diaSemana);
	List<CursoEstudiante> es_claseAnteriorActualSiguiente(Integer id, Integer hora, Integer numeroDia);
	List<CursoEstudiante> ca_claseAnteriorActualSiguiente(Integer id, Integer hora, Integer numeroDia);
	List<EstudianteConsulta> estudiantesClase(Integer id);
	List<EstudianteConsulta> estudiantesFacultad(Integer id);
	List<PorcentajeAsistencia> porcentajeAsistenciasEstudianteCurso(Integer id, Integer idCurso);
}
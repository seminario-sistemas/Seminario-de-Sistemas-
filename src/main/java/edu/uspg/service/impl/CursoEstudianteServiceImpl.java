package edu.uspg.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uspg.dao.ICursoEstudianteDAO;
import edu.uspg.dao.IEstudianteConsultaDAO;
import edu.uspg.dao.IPorcentajeAsistenciaDAO;
import edu.uspg.model.CursoEstudiante;
import edu.uspg.model.EstudianteConsulta;
import edu.uspg.model.PorcentajeAsistencia;
import edu.uspg.service.ICursoEstudianteService;

@Service
public class CursoEstudianteServiceImpl implements ICursoEstudianteService {
	
	@Autowired
	private ICursoEstudianteDAO dao;
	
	@Autowired
	private IEstudianteConsultaDAO dao2;
	
	@Autowired
	private IPorcentajeAsistenciaDAO dao3;
	
	@Override
	public List<CursoEstudiante> clasesEstudiante(Integer id) {
		List<CursoEstudiante> consulta = new ArrayList<>();
		dao.clasesEstudiante(id).forEach(estudiante ->{
			CursoEstudiante curEst = new CursoEstudiante();
			curEst.setId_estudiante(Integer.parseInt(String.valueOf(estudiante[0])));
			curEst.setEstudiante(String.valueOf(estudiante[1]));
			curEst.setId_curso(Integer.parseInt(String.valueOf(estudiante[2])));
			curEst.setCurso(String.valueOf(estudiante[3]));
			curEst.setDia_semana(String.valueOf(estudiante[4]));
			curEst.setNumero_dia(Integer.parseInt(String.valueOf(estudiante[5])));
			curEst.setHora_inicio(Integer.parseInt(String.valueOf(estudiante[6])));
			curEst.setHora_fin(Integer.parseInt(String.valueOf(estudiante[7])));
			curEst.setId_catedratico(Integer.parseInt(String.valueOf(estudiante[8])));
			curEst.setCatedratico(String.valueOf(estudiante[9]));
			consulta.add(curEst);
		});
		return consulta;
	}
	
	@Override
	public List<CursoEstudiante> clasesCatedratico(Integer id) {
		List<CursoEstudiante> consulta = new ArrayList<>();
		dao.clasesCatedratico(id).forEach(estudiante ->{
			CursoEstudiante curEst = new CursoEstudiante();
			curEst.setId_estudiante(Integer.parseInt(String.valueOf(estudiante[0])));
			curEst.setEstudiante(String.valueOf(estudiante[1]));
			curEst.setId_curso(Integer.parseInt(String.valueOf(estudiante[2])));
			curEst.setCurso(String.valueOf(estudiante[3]));
			curEst.setDia_semana(String.valueOf(estudiante[4]));
			curEst.setNumero_dia(Integer.parseInt(String.valueOf(estudiante[5])));
			curEst.setHora_inicio(Integer.parseInt(String.valueOf(estudiante[6])));
			curEst.setHora_fin(Integer.parseInt(String.valueOf(estudiante[7])));
			consulta.add(curEst);
		});
		return consulta;
	}

	@Override
	public List<CursoEstudiante> clasesEstudianteManana(Integer id, Integer diaSemana) {
		List<CursoEstudiante> consulta = new ArrayList<>();
		dao.clasesEstudianteManana(id, diaSemana).forEach(estudiante ->{
			CursoEstudiante curEst = new CursoEstudiante();
			curEst.setId_estudiante(Integer.parseInt(String.valueOf(estudiante[0])));
			curEst.setEstudiante(String.valueOf(estudiante[1]));
			curEst.setId_curso(Integer.parseInt(String.valueOf(estudiante[2])));
			curEst.setCurso(String.valueOf(estudiante[3]));
			curEst.setDia_semana(String.valueOf(estudiante[4]));
			curEst.setNumero_dia(Integer.parseInt(String.valueOf(estudiante[5])));
			curEst.setHora_inicio(Integer.parseInt(String.valueOf(estudiante[6])));
			curEst.setHora_fin(Integer.parseInt(String.valueOf(estudiante[7])));
			consulta.add(curEst);
		});
		return consulta;
	}


	@Override
	public List<CursoEstudiante> clasesCatedraticoManana(Integer id, Integer diaSemana) {
		List<CursoEstudiante> consulta = new ArrayList<>();
		dao.clasesCatedraticoManana(id, diaSemana).forEach(estudiante ->{
			CursoEstudiante curEst = new CursoEstudiante();
			curEst.setId_estudiante(Integer.parseInt(String.valueOf(estudiante[0])));
			curEst.setEstudiante(String.valueOf(estudiante[1]));
			curEst.setId_curso(Integer.parseInt(String.valueOf(estudiante[2])));
			curEst.setCurso(String.valueOf(estudiante[3]));
			curEst.setDia_semana(String.valueOf(estudiante[4]));
			curEst.setNumero_dia(Integer.parseInt(String.valueOf(estudiante[5])));
			curEst.setHora_inicio(Integer.parseInt(String.valueOf(estudiante[6])));
			curEst.setHora_fin(Integer.parseInt(String.valueOf(estudiante[7])));
			consulta.add(curEst);
		});
		return consulta;
	}
	
	@Override
	public List<CursoEstudiante> es_claseAnteriorActualSiguiente(Integer id, Integer hora, Integer numeroDia) {
		List<CursoEstudiante> consulta = new ArrayList<>();
		dao.es_claseAnteriorActualSiguiente(id, hora, numeroDia).forEach(estudiante ->{
			CursoEstudiante curEst = new CursoEstudiante();
			curEst.setId_estudiante(Integer.parseInt(String.valueOf(estudiante[0])));
			curEst.setEstudiante(String.valueOf(estudiante[1]));
			curEst.setId_curso(Integer.parseInt(String.valueOf(estudiante[2])));
			curEst.setCurso(String.valueOf(estudiante[3]));
			curEst.setDia_semana(String.valueOf(estudiante[4]));
			curEst.setNumero_dia(Integer.parseInt(String.valueOf(estudiante[5])));
			curEst.setHora_inicio(Integer.parseInt(String.valueOf(estudiante[6])));
			curEst.setHora_fin(Integer.parseInt(String.valueOf(estudiante[7])));
			consulta.add(curEst);
		});
		return consulta;
	}

	@Override
	public List<CursoEstudiante> ca_claseAnteriorActualSiguiente(Integer id, Integer hora, Integer numeroDia) {
		List<CursoEstudiante> consulta = new ArrayList<>();
		dao.ca_claseAnteriorActualSiguiente(id, hora, numeroDia).forEach(estudiante ->{
			CursoEstudiante curEst = new CursoEstudiante();
			curEst.setId_catedratico(Integer.parseInt(String.valueOf(estudiante[0])));
			curEst.setCatedratico(String.valueOf(estudiante[1]));
			curEst.setId_curso(Integer.parseInt(String.valueOf(estudiante[2])));
			curEst.setCurso(String.valueOf(estudiante[3]));
			curEst.setDia_semana(String.valueOf(estudiante[4]));
			curEst.setNumero_dia(Integer.parseInt(String.valueOf(estudiante[5])));
			curEst.setHora_inicio(Integer.parseInt(String.valueOf(estudiante[6])));
			curEst.setHora_fin(Integer.parseInt(String.valueOf(estudiante[7])));
			consulta.add(curEst);
		});
		return consulta;
	}
	
	@Override
	public List<EstudianteConsulta> estudiantesClase(Integer id) {
		List<EstudianteConsulta> consulta = new ArrayList<>();
		dao2.estudiantesClase(id).forEach(estudiante ->{
			EstudianteConsulta estCon = new EstudianteConsulta();
			estCon.setId_estudiante(Integer.parseInt(String.valueOf(estudiante[0])));
			estCon.setCarnet(String.valueOf(estudiante[1]));
			estCon.setCorreo_personal(String.valueOf(estudiante[2]));
			estCon.setDpi(String.valueOf(estudiante[3]));
			estCon.setJornada(String.valueOf(estudiante[4]));
			estCon.setNombre(String.valueOf(estudiante[5]));
			estCon.setId_facultad(Integer.parseInt(String.valueOf(estudiante[6])));
			estCon.setFacultad(String.valueOf(estudiante[7]));
			consulta.add(estCon);
		});
		return consulta;
	}

	@Override
	public List<EstudianteConsulta> estudiantesFacultad(Integer id) {
		List<EstudianteConsulta> consulta = new ArrayList<>();
		dao2.estudiantesFacultad(id).forEach(estudiante ->{
			EstudianteConsulta estCon = new EstudianteConsulta();
			estCon.setId_estudiante(Integer.parseInt(String.valueOf(estudiante[0])));
			estCon.setCarnet(String.valueOf(estudiante[1]));
			estCon.setCorreo_personal(String.valueOf(estudiante[2]));
			estCon.setDpi(String.valueOf(estudiante[3]));
			estCon.setJornada(String.valueOf(estudiante[4]));
			estCon.setNombre(String.valueOf(estudiante[5]));
			estCon.setId_facultad(Integer.parseInt(String.valueOf(estudiante[6])));
			estCon.setFacultad(String.valueOf(estudiante[7]));
			consulta.add(estCon);
		});
		return consulta;
	}
	
	@Override
	public List<PorcentajeAsistencia> porcentajeAsistenciasEstudianteCurso(Integer id, Integer idCurso) {
		List<PorcentajeAsistencia> consulta = new ArrayList<>();
		dao3.porcentajeAsistenciasEstudianteCurso(id,idCurso).forEach(estudiante ->{
			PorcentajeAsistencia porAs = new PorcentajeAsistencia();
			porAs.setId_estudiante(Integer.parseInt(String.valueOf(estudiante[0])));
			porAs.setEstudiante(String.valueOf(estudiante[1]));
			porAs.setId_curso(Integer.parseInt(String.valueOf(estudiante[2])));
			porAs.setCurso(String.valueOf(estudiante[3]));
			porAs.setPorcentaje(Float.parseFloat(String.valueOf(estudiante[4])));
			consulta.add(porAs);
		});
		return consulta;
	}
	
}

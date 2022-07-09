/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.com.progweb.prueba.rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import py.com.progweb.prueba.ejb.DetalleDao;
import py.com.progweb.prueba.ejb.FichaDao;
import py.com.progweb.prueba.model.Detalle;
import py.com.progweb.prueba.model.Ficha;
import py.com.progweb.prueba.model.Medico;
import py.com.progweb.prueba.model.Paciente;


/**
 *
 * @author nruiz
 */
@Path("ficha")
@Consumes("application/json")
@Produces("application/json")
@Stateless
public class FichaRest {
    @Inject 
    private FichaDao fichaDao;
     @POST
    @Path("/")
    public Response crear(Ficha ficha){
        int id=this.fichaDao.CrearFicha(ficha);
        return Response.ok(id).build();
    }
    
    @GET
    @Path("/")
    public Response listarFichas() {
        return Response.ok(fichaDao.ListarFichas()).build();
    }
    
    
    @GET
    @Path("/{fichaId}")
    public Response getMedico(@PathParam("fichaId") int fichaId) {
               
        return Response.ok(fichaDao.GetFicha(fichaId)).build();
    }
    
    @PUT
    @Path("/update")
    public Response updateFicha(Ficha ficha) {
        this.fichaDao.UpdateFicha(ficha);
        return Response.ok().build();
    }
    
    
    @DELETE
    @Path("/{fichaId}")
    public Response deleteFicha(@PathParam("fichaId") int fichaId) {
        fichaDao.DeleteFicha(fichaId);
        return Response.ok().build();
    }
    
    @GET
    @Path("/especialidad/{especialidad}")
    public Response getMedicoEspecialidad(@PathParam("especialidad") String especialidad) {
               
        return Response.ok(fichaDao.ListarDetallesEspecialidadMedico(especialidad)).build();
    }
    
   
    
    
    @POST
    @Path("/pacienteCedula")
    public Response ListarDetallesPacientePorCedula( Paciente paciente) {
       
         
        return Response.ok(fichaDao.ListarDetallesPacientePorCedula(paciente.getCedula())).build();
    }
    
    
    @POST
    @Path("/detalleFecha")
    public Response ListarDetallesPorFecha( Detalle detalle) {
           
        return Response.ok(fichaDao.ListarDetallesPorFecha(detalle.getFecha())).build();
    }
    
    @GET
    @Path("/fichaMedico/{medicoId}")
    public Response GetFichaPorMedicos(@PathParam("medicoId") int medicoId) {
               
        return Response.ok(fichaDao.GetFichaPorMedicos(medicoId)).build();
    }
    @GET
    @Path("/fichaMedico/{cedula}/paciente/{pacienteId}")
    public Response GetFichaPorMedicoYPaciente(@PathParam("cedula") String cedula,@PathParam("pacienteId") int pacienteId) {
               
        return Response.ok(fichaDao.GetFichaPorMedicoYPaciente(cedula,pacienteId)).build();
    }
    
    @POST
    @Path("/fichaMedicoCedula")
    public Response GetFichaPorMedicosCedula(Medico medico) {
               
        return Response.ok(fichaDao.GetFichaPorMedicosCedula(medico.getCedula())).build();
    }
    
    @POST
    @Path("/fichaMedicoEspecialidad")
    public Response GetFichaPorMedicosEspecialidad(Medico medico) {
               
        return Response.ok(fichaDao.GetFichaPorMedicosEspecialidad(medico.getEspecialidad())).build();
    }
    
    @POST
    @Path("/fichaPacienteCedula")
    public Response GetFichaPorPacienteCedula(Paciente paciente) {
         System.out.println("aaaaaaaaaaaaaaaaaaaaaa"+paciente.getCedula());
        return Response.ok(fichaDao.GetFichaPorPacienteCedula(paciente.getCedula())).build();
    }
    
    @GET
    @Path("/fichaPaciente/{cedula}/medico/{medicoId}")
    public Response GetFichaPorPacienteYMedico(@PathParam("cedula") String cedula,@PathParam("medicoId") int medicoId) {
               
        return Response.ok(fichaDao.GetFichaPorPacienteYMedico(cedula,medicoId)).build();
    }
    
    
    @GET
    @Path("/fichaPaciente/{id}")
    public Response GetFichaPorPacienteIdGet(@PathParam("id") int id) {
               
        return Response.ok(fichaDao.GetFichaPorPacienteIdGet(id)).build();
    }
    
    ///////////////////////////////////////////7
    
    @POST
    @Path("/pacienteCedula")
    public Response GetFichaPorCedulaPaciente(Paciente paciente) {
         System.out.println("aaaaaaaaaaaaaaaaaaaaaa"+paciente.getCedula());
        return Response.ok(fichaDao.GetFichaPorCedulaPaciente(paciente.getCedula())).build();
    }
    
    @POST
    @Path("/especialidad")
    public Response GetFichaPorEspecialidad(Medico medico) {
         
        return Response.ok(fichaDao.GetFichaPorEspecialidad(medico.getEspecialidad())).build();
    }
    
    @POST
    @Path("/medicoCedula")
    public Response  GetFichaPorCedulaMedico(Medico medico) {
         
        return Response.ok(fichaDao.GetFichaPorCedulaMedico(medico.getCedula())).build();
    }
    
    @POST
    @Path("/pacienteId")
    public Response  GetFichaPorPacienteIdEspecialidad(Medico paciente) {
         
        return Response.ok(fichaDao.GetFichaPorPacienteIdEspecialidad(paciente.getId(),paciente.getEspecialidad())).build();
    }
    
    @POST
    @Path("/pacienteIdMedicoCedula")
    public Response  GetFichaPorPacienteIdMedicoCedula(Medico paciente) {
         
        return Response.ok(fichaDao.GetFichaPorPacienteIdMedicoCedula(paciente.getId(),paciente.getCedula())).build();
    }
    
    
     @POST
    @Path("/pacienteCedulaMedicoId")
    public Response  GetFichaPorPacienteCedulaMedicoId(Medico paciente) {
         
        return Response.ok(fichaDao.GetFichaPorPacienteCedulaMedicoId(paciente.getCedula(),paciente.getId())).build();
    }
    
    @POST
    @Path("/medicoId")
    public Response  GetFichaPorMedicoId(Medico medico) {
         
        return Response.ok(fichaDao.GetFichaPorMedicoId(medico.getId())).build();
    }
}

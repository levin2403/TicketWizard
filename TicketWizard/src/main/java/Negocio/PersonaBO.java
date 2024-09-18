/**
 *
 */
package Negocio;

import DAO.DomicilioDAO;
import DAO.PersonaDAO;
import DTOs.DomicilioDTO;
import DTOs.PersonaDTO;
import Entidades.Domicilio;
import Entidades.Persona;
import Excepciones.BOException;
import Excepciones.DAOException;
import InterfacesDAO.IPersonaDAO;
import InterfacesNegocio.IPersonaBO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author/(s) Kevin Jared Sánchez Figueroa - 240798.
 *             Daniel Alejandro Castro Félix - 235294.
 */
public class PersonaBO implements IPersonaBO {

    private final IPersonaDAO personaDAO;
    private final DomicilioBO domicilioBO; // Para manejar el domicilio

    public PersonaBO() {
        this.personaDAO = new PersonaDAO();
        this.domicilioBO = new DomicilioBO();
    }

    @Override
    public PersonaDTO consultar(String correo) throws BOException {
        try{
           // Consultar la persona usando el DAO
           Persona persona = personaDAO.consultar(correo);
           return convertirADTO(persona);
        }
        catch(DAOException ex){
            throw new BOException(ex.getMessage());
        }
    }

    @Override
    public void agregar(PersonaDTO personaDTO) throws BOException {
        // Convertir DTO a entidad
        Persona persona = null;
        try {
            persona = convertirAEntidad(personaDTO);
            personaDAO.agregar(persona);
        } catch (DAOException ex) {
            Logger.getLogger(PersonaBO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizar(PersonaDTO personaDTO) throws BOException {
        // Convertir DTO a entidad
        Persona persona = null;
        try {
            persona = convertirAEntidad(personaDTO);
            personaDAO.actualizar(persona);
        } catch (DAOException ex) {
            Logger.getLogger(PersonaBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    // Convertir de PersonaDTO a Persona
    private Persona convertirAEntidad(PersonaDTO dto) throws BOException {
//        // Consultar el domicilio asociado al DTO
//        DomicilioDTO domicilioDTO = domicilioBO.consultar(new DomicilioDTO(dto.getIdDomicilio()));
//
//        // Convertir el saldo de double a BigDecimal
//        BigDecimal saldo = BigDecimal.valueOf(dto.getSaldo());
//
//        // Convertir DomicilioDTO a Domicilio
//        Domicilio domicilio = convertirADomicilio(domicilioDTO);
//
//        return new Persona(
//                dto.getId(),
//                dto.getNombre(),
//                dto.getContraseña(),
//                dto.getFechaNacimiento(),
//                dto.getCorreo(),
//                dto.getEdad(),
//                saldo,
//                domicilio,
//                dto.getGeneratedKey()
//        );
return null;
    }

    // Convertir de Persona a PersonaDTO
    private PersonaDTO convertirADTO(Persona persona) {
        // Convertir el saldo de BigDecimal a double
//        double saldo = persona.getSaldo().doubleValue();
//
//        return new PersonaDTO(
//                persona.getId(),
//                persona.getNombre(),
//                persona.getContraseña(),
//                persona.getFechaNacimiento(),
//                persona.getCorreo(),
//                persona.getEdad(),
//                saldo, // Convertido a double
//                persona.getDomicilio().getId(),
//                persona.getGeneratedKey()
//        );
return null;
    }

    private Domicilio convertirADomicilio(DomicilioDTO dto) {
//        return new Domicilio(
//                dto.getId(),
//                dto.getCiudad(),
//                dto.getColonia(),
//                dto.getCalle(),
//                dto.getNumExterior(),
//                dto.getNumInterior(),
//                dto.getCodigoPostal()
//        );
return null;
    }

    @Override
    public boolean consultarContrasena(String correo, String contrasena) throws BOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

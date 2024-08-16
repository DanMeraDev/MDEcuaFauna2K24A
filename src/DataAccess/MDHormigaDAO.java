package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;


import DataAccess.DTO.HormigaDTO;

public class MDHormigaDAO extends MDSQLiteDataHelper implements IDAO<HormigaDTO>{
    private static final Logger logger = Logger.getLogger(MDHormigaDAO.class.getName());
    String SQL_CREATE = "INSERT INTO Hormiga" +
    "(TipoHormiga, IdSexo, IdProvincia, IdGenoAlimento, IdIngesta, Estado)" +
    "VALUES (?,?,?,?,?,?)";
    
    private static final String SQL_SELECT_SEXO = "SELECT IdSexo FROM Sexo WHERE TipoSexo = ?";
    private static final String SQL_SELECT_PROVINCIA = "SELECT IdProvincia FROM Provincia WHERE NombreProvincia = ?";
    private static final String SQL_SELECT_GENOALIMENTO = "SELECT IdGenoAlimento FROM GenoAlimento WHERE Gen = ?";
    private static final String SQL_SELECT_INGESTA = "SELECT IdIngesta FROM IngestaNativa WHERE TipoAnimal = ?";
    private static final String SQL_READ_BY_ID = 
    "SELECT h.IdHormiga, h.TipoHormiga,s.TipoSexo,p.NombreProvincia,g.Gen,i.TipoAnimal,h.Estado " + 
    "FROM Hormiga h INNER JOIN Sexo s ON h.IdSexo = s.IdSexo " + 
    "INNER JOIN Provincia p ON h.IdProvincia = p.IdProvincia INNER JOIN GenoAlimento g ON h.IdGenoAlimento = g.IdGenoAlimento " + 
    "INNER JOIN IngestaNativa i ON h.IdIngesta = i.IdIngesta WHERE h.IdHormiga = ?";
    private static final String SQL_DELETE = "DELETE FROM Hormiga WHERE IdHormiga = ?";

    @Override
    public boolean create(HormigaDTO entity) throws Exception {
        ResultSet rsSexo = null;
        ResultSet rsProvincia = null;
        ResultSet rsGenoAlimento = null;
        ResultSet rsIngesta = null;

        try {
            logger.info("Creando Hormiga");
    
            Connection conn = mdOpenConnection();
    
            PreparedStatement psSexo = conn.prepareStatement(SQL_SELECT_SEXO);
            psSexo.setString(1, entity.getMdSexo());
            rsSexo = psSexo.executeQuery();
            int idSexo = rsSexo.next() ? rsSexo.getInt("IdSexo") : 0;
    
            PreparedStatement psProvincia = conn.prepareStatement(SQL_SELECT_PROVINCIA);
            psProvincia.setString(1, entity.getMdUbicacion());
            rsProvincia = psProvincia.executeQuery();
            int idProvincia = rsProvincia.next() ? rsProvincia.getInt("IdProvincia") : 0;
            PreparedStatement psGenoAlimento = conn.prepareStatement(SQL_SELECT_GENOALIMENTO);
            psGenoAlimento.setString(1, entity.getMdGenoAlimento());
            rsGenoAlimento = psGenoAlimento.executeQuery();
            int idGenoAlimento = rsGenoAlimento.next() ? rsGenoAlimento.getInt("IdGenoAlimento") : 0;
            PreparedStatement psIngesta = conn.prepareStatement(SQL_SELECT_INGESTA);
            psIngesta.setString(1, entity.getMdIngestaNativa());
            rsIngesta = psIngesta.executeQuery();
            int idIngesta = rsIngesta.next() ? rsIngesta.getInt("IdIngesta") : 0;
            PreparedStatement psInsert = conn.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, entity.getMdTipoHormiga());
            psInsert.setInt(2, idSexo); 
            psInsert.setInt(3, idProvincia); 
            psInsert.setInt(4, idGenoAlimento); 
            psInsert.setInt(5, idIngesta); 
            psInsert.setString(6, entity.getMdEStado());
            
            psInsert.executeUpdate();
            return true;
    
        } catch (Exception e) {
            logger.warning("Error al crear hormiga, " + e.getMessage());
        } finally {
            if (rsSexo != null) rsSexo.close();
            if (rsProvincia != null) rsProvincia.close();
            if (rsGenoAlimento != null) rsGenoAlimento.close();
            if (rsIngesta != null) rsIngesta.close();
        }
        return false;
    }
    

    @Override
    public HormigaDTO readByID(int id) throws Exception {
        logger.info("Iniciando lectura de Hormiga con id: " + id);
        HormigaDTO hormigaDTO = new HormigaDTO();
        ResultSet rs = null;
        try {
            Connection conn = mdOpenConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_READ_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
  
            if (rs.next()) {
                hormigaDTO = new HormigaDTO(
                    rs.getInt("IdHormiga"), 
                    rs.getString("TipoHormiga"), 
                    rs.getString("TipoSexo"), 
                    rs.getString("NombreProvincia"), 
                    rs.getString("Gen"), 
                    rs.getString("TipoAnimal"), 
                    rs.getString("Estado")
                );
            } else {
                logger.warning("No se encontró la hormiga con id: " + id);
            }
        } catch (Exception e) {
            logger.warning("Error al leer hormiga con id: " + id + ", " + e.getMessage());
        } finally {
            if (rs != null) rs.close();
        }
        return hormigaDTO;
    }


    @Override
    public boolean update(HormigaDTO entity) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean delete(int id) throws Exception {
        logger.info("Iniciando el borrado de Hormiga");
        try {
            Connection conn = mdOpenConnection();
            PreparedStatement ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            logger.warning("Error al borrar hormiga con id: " + id + ", " + e.getMessage());
        }
        return false;
    }

}

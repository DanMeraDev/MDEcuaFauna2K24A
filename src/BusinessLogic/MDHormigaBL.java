package BusinessLogic;

import DataAccess.MDHormigaDAO;
import DataAccess.DTO.HormigaDTO;

public class MDHormigaBL {
    private MDHormigaDAO iDao = new MDHormigaDAO();

    public MDHormigaBL() {
    }

    public boolean mdCrearHormiga(HormigaDTO hormiga) throws Exception {
        return iDao.create(hormiga);
    }

    public HormigaDTO mdLeerHormigaPorId(int id) throws Exception {
        return iDao.readByID(id);
    }

    public boolean mdBorrarHormigaPorId(int id) throws Exception {
        HormigaDTO mdHormigaAuxiliar = iDao.readByID(id);
    
        if (mdHormigaAuxiliar != null && mdHormigaAuxiliar.getMdEStado() != null && !mdHormigaAuxiliar.getMdEStado().isEmpty()) {
            return iDao.delete(id);
        }
        return false;
    }
    

}

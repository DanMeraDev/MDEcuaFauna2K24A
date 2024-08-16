
import BusinessLogic.MDHormigaBL;
import DataAccess.MDHormigaDAO;
import DataAccess.DTO.HormigaDTO;
import UserInterface.GUI.MDVentana;

public class App {
    public static void main(String[] args) throws Exception {
        MDVentana ventana = new MDVentana();
        HormigaDTO hormigaDTO = new HormigaDTO(1, "Larva", "Pichincha", "Asexual", "XX", "Omnívoro", "VIVA");
        MDHormigaBL hormigaBL = new MDHormigaBL();
        hormigaBL.mdCrearHormiga(hormigaDTO);
        System.out.println(hormigaBL.mdLeerHormigaPorId(1));
    }
}

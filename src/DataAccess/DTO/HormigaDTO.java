package DataAccess.DTO;

public class HormigaDTO {
    private int mdRegistro;
    private String mdTipoHormiga;
    private String mdUbicacion;
    private String mdSexo;
    private String mdGenoAlimento;
    private String mdIngestaNativa;
    private String mdEStado;
    
    public HormigaDTO(int mdRegistro, String mdTipoHormiga, String mdUbicacion, String mdSexo, String mdGenoAlimento,
            String mdIngestaNativa, String mdEStado) {
        this.mdRegistro = mdRegistro;
        this.mdTipoHormiga = mdTipoHormiga;
        this.mdUbicacion = mdUbicacion;
        this.mdSexo = mdSexo;
        this.mdGenoAlimento = mdGenoAlimento;
        this.mdIngestaNativa = mdIngestaNativa;
        this.mdEStado = mdEStado;
    }
    public HormigaDTO() {
    }
    public int getMdRegistro() {
        return mdRegistro;
    }

    public void setMdRegistro(int mdRegistro) {
        this.mdRegistro = mdRegistro;
    }
    public String getMdTipoHormiga() {
        return mdTipoHormiga;
    }
    public void setMdTipoHormiga(String mdTipoHormiga) {
        this.mdTipoHormiga = mdTipoHormiga;
    }
    public String getMdUbicacion() {
        return mdUbicacion;
    }
    public void setMdUbicacion(String mdUbicacion) {
        this.mdUbicacion = mdUbicacion;
    }
    public String getMdSexo() {
        return mdSexo;
    }
    public void setMdSexo(String mdSexo) {
        this.mdSexo = mdSexo;
    }
    public String getMdGenoAlimento() {
        return mdGenoAlimento;
    }
    public void setMdGenoAlimento(String mdGenoAlimento) {
        this.mdGenoAlimento = mdGenoAlimento;
    }
    public String getMdIngestaNativa() {
        return mdIngestaNativa;
    }
    public void setMdIngestaNativa(String mdIngestaNativa) {
        this.mdIngestaNativa = mdIngestaNativa;
    }
    public String getMdEStado() {
        return mdEStado;
    }
    public void setMdEStado(String mdEStado) {
        this.mdEStado = mdEStado;
    }
    @Override
    public String toString() {
        return "HormigaDTO [mdTipoHormiga=" + mdTipoHormiga + ", mdUbicacion=" + mdUbicacion + ", mdSexo=" + mdSexo
                + ", mdGenoAlimento=" + mdGenoAlimento + ", mdIngestaNativa=" + mdIngestaNativa + ", mdEStado="
                + mdEStado + "]";
    }


    
}

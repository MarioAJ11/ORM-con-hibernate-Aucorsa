import jakarta.persistence.*;

@Entity
@Table(name = "Bus")
public class Bus {

    @Id
    @Column(name = "Registro")
    private int registro;

    @Column(name = "Tipo", length = 100)
    private String tipo;

    @Column(name = "Licencia")
    private int licencia;

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getLicencia() {
        return licencia;
    }

    public void setLicencia(int licencia) {
        this.licencia = licencia;
    }

    public Bus() {}

    public Bus(int registro, String tipo, int licencia) {
        this.registro = registro;
        this.tipo = tipo;
        this.licencia = licencia;
    }
}


package Model;
// Generated 04/09/2013 00:26:25 by Hibernate Tools 3.2.1.GA

import Dao.ClienteDao;
import Dao.ClienteDaoImp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Venda generated by hbm2java
 */
@Entity
@Table(name = "venda", catalog = "redemais_db")
public class Venda implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_venda", unique = true, nullable = false)
    private Integer idVenda;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;
    @Column(name = "valor", nullable = false, precision = 22, scale = 0)
    private double valor;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_venda", nullable = false, length = 10)
    private Date dataVenda;
    @Temporal(TemporalType.TIME)
    @Column(name = "hora", nullable = false, length = 8)
    private Date hora;
    @Column(name = "status", nullable = false, length = 1)
    private char status;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "venda")
    private List<Cancelamento> cancelamentos = new ArrayList<Cancelamento>();
    private int idCliente;

    public Venda() {
    }

    public Venda(Cliente cliente, double valor, Date dataVenda, Date hora, char status) {
        this.cliente = cliente;
        this.valor = valor;
        this.dataVenda = dataVenda;
        this.hora = hora;
        this.status = status;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        ClienteDao dao = new ClienteDaoImp();
        this.cliente = dao.getCliente(idCliente);
    }

    public Integer getIdVenda() {
        return this.idVenda;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDataVenda() {
        return this.dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Date getHora() {
        return this.hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public char getStatus() {
        return this.status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public List<Cancelamento> getCancelamentos() {
        return this.cancelamentos;
    }

    public void setCancelamentos(List<Cancelamento> cancelamentos) {
        this.cancelamentos = cancelamentos;
    }
}

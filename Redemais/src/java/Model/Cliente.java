package Model;

import java.sql.Date;
import java.util.ArrayList;
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
import javax.persistence.UniqueConstraint;

/**
 * Cliente generated by hbm2java
 */
@Entity
@Table(name = "cliente", catalog = "redemais_db", uniqueConstraints =
        @UniqueConstraint(columnNames = "cpf"))
public class Cliente implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_cliente", unique = true, nullable = false)
    private Integer idCliente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "padrinho", nullable = false)
    private Empresa empresa;
    @Column(name = "pag_banco", nullable = false)
    private int pagBanco;
    @Column(name = "cpf", unique = true, nullable = false, length = 11)
    private String cpf;
    @Column(name = "rg", nullable = false, length = 20)
    private String rg;
    @Column (name ="data_nascimento", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;
    @Column(name = "sexo", nullable = false)
    private String sexo;
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Column(name = "fone_res_ddd", length = 2)
    private String foneResDdd;
    @Column(name = "fone_res", length = 8)
    private String foneRes;
    @Column(name = "fone_cel_ddd", nullable = false, length = 2)
    private String foneCelDdd;
    @Column(name = "fone_cel", nullable = false, length = 8)
    private String foneCel;
    @Column(name = "end_rua", nullable = false, length = 60)
    private String endRua;
    @Column(name = "end_numero", nullable = false, length = 10)
    private String endNumero;
    @Column(name = "end_complemento", nullable = false, length = 45)
    private String endComplemento;
    @Column(name = "end_cidade", nullable = false, length = 45)
    private String endCidade;
    @Column(name = "end_estado", nullable = false, length = 2)
    private String endEstado;
    @Column (name = "end_bairro", nullable = false, length = 45)
    private String endBairro;
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    @Column(name = "pag_tipo_conta", nullable = false, length = 10)
    private String pagTipoConta;
    @Column(name = "pag_agencia", nullable = false, length = 10)
    private String pagAgencia;
    @Column(name = "pag_dig_agencia", nullable = false, length = 10)
    private String pagDigAgencia;
    @Column(name = "pag_dig_conta", nullable = false, length = 10)
    private String pagConta;
    @Column(name = "pag_conta", nullable = false, length = 10)
    private String pagDigConta;
    @Column(name = "pag_cidade_agencia", nullable = false, length = 30)
    private String pagCidadeAgencia;
    @Column(name = "status_cartao", nullable = false, length = 1)
    private char statusCartao;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente")
    private List<Venda> vendas = new ArrayList<Venda>();

    public Cliente() {
    }

    public Cliente(Empresa empresa, int pagBanco, String cpf, String rg, Date dataNascimento, String sexo, String nome, String foneResDdd, String foneRes, String foneCelDdd, String foneCel, String endRua, String endNumero, String endComplemento, String endCidade, String endEstado, String endBairro, String email, String pagTipoConta, String pagAgencia, String pagDigAgencia, String pagConta, String pagDigConta, String pagCidadeAgencia, char statusCartao) {
        this.empresa = empresa;
        this.pagBanco = pagBanco;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.nome = nome;
        this.foneResDdd = foneResDdd;
        this.foneRes = foneRes;
        this.foneCelDdd = foneCelDdd;
        this.foneCel = foneCel;
        this.endRua = endRua;
        this.endNumero = endNumero;
        this.endComplemento = endComplemento;
        this.endCidade = endCidade;
        this.endEstado = endEstado;
        this.endBairro = endBairro;
        this.email = email;
        this.pagTipoConta = pagTipoConta;
        this.pagAgencia = pagAgencia;
        this.pagDigAgencia = pagDigAgencia;
        this.pagConta = pagConta;
        this.pagDigConta = pagDigConta;
        this.pagCidadeAgencia = pagCidadeAgencia;
        this.statusCartao = statusCartao;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public int getPagBanco() {
        return pagBanco;
    }

    public void setPagBanco(int pagBanco) {
        this.pagBanco = pagBanco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoneResDdd() {
        return foneResDdd;
    }

    public void setFoneResDdd(String foneResDdd) {
        this.foneResDdd = foneResDdd;
    }

    public String getFoneRes() {
        return foneRes;
    }

    public void setFoneRes(String foneRes) {
        this.foneRes = foneRes;
    }

    public String getFoneCelDdd() {
        return foneCelDdd;
    }

    public void setFoneCelDdd(String foneCelDdd) {
        this.foneCelDdd = foneCelDdd;
    }

    public String getFoneCel() {
        return foneCel;
    }

    public void setFoneCel(String foneCel) {
        this.foneCel = foneCel;
    }

    public String getEndRua() {
        return endRua;
    }

    public void setEndRua(String endRua) {
        this.endRua = endRua;
    }

    public String getEndNumero() {
        return endNumero;
    }

    public void setEndNumero(String endNumero) {
        this.endNumero = endNumero;
    }

    public String getEndComplemento() {
        return endComplemento;
    }

    public void setEndComplemento(String endComplemento) {
        this.endComplemento = endComplemento;
    }

    public String getEndCidade() {
        return endCidade;
    }

    public void setEndCidade(String endCidade) {
        this.endCidade = endCidade;
    }

    public String getEndEstado() {
        return endEstado;
    }

    public void setEndEstado(String endEstado) {
        this.endEstado = endEstado;
    }

    public String getEndBairro() {
        return endBairro;
    }

    public void setEndBairro(String endBairro) {
        this.endBairro = endBairro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPagTipoConta() {
        return pagTipoConta;
    }

    public void setPagTipoConta(String pagTipoConta) {
        this.pagTipoConta = pagTipoConta;
    }

    public String getPagAgencia() {
        return pagAgencia;
    }

    public void setPagAgencia(String pagAgencia) {
        this.pagAgencia = pagAgencia;
    }

    public String getPagDigAgencia() {
        return pagDigAgencia;
    }

    public void setPagDigAgencia(String pagDigAgencia) {
        this.pagDigAgencia = pagDigAgencia;
    }

    public String getPagConta() {
        return pagConta;
    }

    public void setPagConta(String pagConta) {
        this.pagConta = pagConta;
    }

    public String getPagDigConta() {
        return pagDigConta;
    }

    public void setPagDigConta(String pagDigConta) {
        this.pagDigConta = pagDigConta;
    }

    public String getPagCidadeAgencia() {
        return pagCidadeAgencia;
    }

    public void setPagCidadeAgencia(String pagCidadeAgencia) {
        this.pagCidadeAgencia = pagCidadeAgencia;
    }

    public char getStatusCartao() {
        return statusCartao;
    }

    public void setStatusCartao(char statusCartao) {
        this.statusCartao = statusCartao;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    
}

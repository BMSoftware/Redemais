package Model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Empresa generated by hbm2java
 */
@Entity
@Table(name = "empresa", catalog = "redemais_db")
public class Empresa implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_empresa", unique = true, nullable = false)
    private Integer idEmpresa;
    @Column(name = "razao_social", nullable = false, length = 100)
    private String razaoSocial;
    @Column(name = "nome_fantasia", nullable = false, length = 40)
    private String nomeFantasia;
    @Column(name = "cnpj", nullable = false, length = 14)
    private String cnpj;
    @Column(name = "end_rua", length = 60)
    private String endRua;
    @Column(name = "end_numero", length = 10)
    private String endNumero;
    @Column(name = "end_cidade", length = 30)
    private String endCidade;
    @Column(name = "end_complemento", length = 45)
    private String endComplemento;
    @Column(name = "fone_ddd", length = 2)
    private String foneDdd;
    @Column(name = "fone", length = 8)
    private String fone;
    @Column(name = "tipo_conta", length = 10)
    private String tipoConta;
    @Column(name = "banco", length = 10)
    private String banco;
    @Column(name = "agencia", length = 10)
    private String agencia;
    @Column(name = "dig_agencia", length = 10)
    private String digAgencia;
    @Column(name = "tipo_pagamento", length = 1)
    private Character tipoPagamento;
    @Column(name = "email", length = 45)
    private String email;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "empresa")
    private List<Cliente> clientes = new ArrayList<Cliente>();
    @OneToMany(targetEntity = Usuario.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "empresa")
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public Empresa() {
    }

    public Empresa(String razaoSocial, String nomeFantasia, String cnpj, String endRua, String endNumero, String endCidade, String endComplemento, String foneDdd, String fone, String tipoConta, String banco, String agencia, String digAgencia, Character tipoPagamento, String EMail) {
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
        this.endRua = endRua;
        this.endNumero = endNumero;
        this.endCidade = endCidade;
        this.endComplemento = endComplemento;
        this.foneDdd = foneDdd;
        this.fone = fone;
        this.tipoConta = tipoConta;
        this.banco = banco;
        this.agencia = agencia;
        this.digAgencia = digAgencia;
        this.tipoPagamento = tipoPagamento;
        this.email = EMail;
    }

    public Integer getIdEmpresa() {
        return this.idEmpresa;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndRua() {
        return this.endRua;
    }

    public void setEndRua(String endRua) {
        this.endRua = endRua;
    }

    public String getEndNumero() {
        return this.endNumero;
    }

    public void setEndNumero(String endNumero) {
        this.endNumero = endNumero;
    }

    public String getEndCidade() {
        return this.endCidade;
    }

    public void setEndCidade(String endCidade) {
        this.endCidade = endCidade;
    }

    public String getEndComplemento() {
        return this.endComplemento;
    }

    public void setEndComplemento(String endComplemento) {
        this.endComplemento = endComplemento;
    }

    public String getFoneDdd() {
        return this.foneDdd;
    }

    public void setFoneDdd(String foneDdd) {
        this.foneDdd = foneDdd;
    }

    public String getFone() {
        return this.fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getTipoConta() {
        return this.tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getBanco() {
        return this.banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return this.agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getDigAgencia() {
        return this.digAgencia;
    }

    public void setDigAgencia(String digAgencia) {
        this.digAgencia = digAgencia;
    }

    public Character getTipoPagamento() {
        return this.tipoPagamento;
    }

    public void setTipoPagamento(Character tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getEMail() {
        return this.email;
    }

    public void setEMail(String EMail) {
        this.email = EMail;
    }

    public List<Cliente> getClientes() {
        return this.clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}

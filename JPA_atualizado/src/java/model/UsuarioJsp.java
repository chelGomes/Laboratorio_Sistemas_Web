/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Michel
 */
@Entity
@Table(name = "USUARIO_JSP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioJsp.findAll", query = "SELECT u FROM UsuarioJsp u"),
    @NamedQuery(name = "UsuarioJsp.findById", query = "SELECT u FROM UsuarioJsp u WHERE u.id = :id"),
    @NamedQuery(name = "UsuarioJsp.findByUsuario", query = "SELECT u FROM UsuarioJsp u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "UsuarioJsp.findBySenha", query = "SELECT u FROM UsuarioJsp u WHERE u.senha = :senha")})
public class UsuarioJsp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "USUARIO")
    private String usuario;
    @Size(max = 25)
    @Column(name = "SENHA")
    private String senha;

    public UsuarioJsp() {
    }

    public UsuarioJsp(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioJsp)) {
            return false;
        }
        UsuarioJsp other = (UsuarioJsp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.UsuarioJsp[ id=" + id + " ]";
    }
    
}

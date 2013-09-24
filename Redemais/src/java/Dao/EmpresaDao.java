package Dao;

import Model.Empresa;
import Model.Usuario;

/**
 *
 * @author Bruno
 */
public interface EmpresaDao {
 
    public Empresa getEmpresa(int idEmpresa);
    
    public Empresa getEmpresa(Usuario usuario);
}

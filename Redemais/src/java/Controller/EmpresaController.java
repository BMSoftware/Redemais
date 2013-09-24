package Controller;

import Dao.EmpresaDao;
import Dao.EmpresaDaoImp;
import Model.Empresa;
import Model.Usuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "empresaController", eager = true)
@SessionScoped
public class EmpresaController implements Serializable {

    private Empresa empresa;

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}

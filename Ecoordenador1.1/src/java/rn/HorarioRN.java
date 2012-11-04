package rn;
import beans.Horario;
import java.util.List;
import util.DAOFactory;
import util.InterfaceHibernateDAO;

public class HorarioRN {
    
    private InterfaceHibernateDAO<Horario> horarioDAO;
    
    public HorarioRN(){
        this.horarioDAO = DAOFactory.criarHorarioDAO();
    }
    
    public void salvar(Horario horario){
        this.horarioDAO.salvar(horario);
    }
    public List<Horario> listar(){
        return this.horarioDAO.listar();
    }
    public void atualizar(Horario horario){
        this.horarioDAO.atualizar(horario);
    }
    public void excluir(Horario horario){
        this.horarioDAO.excluir(horario);
    }
    public Horario carregar(Integer codigo){
        return this.horarioDAO.carregar(codigo);
    }
}

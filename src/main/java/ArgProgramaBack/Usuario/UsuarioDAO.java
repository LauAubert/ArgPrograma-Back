package ArgProgramaBack.Usuario;

public class UsuarioDAO {
    public static boolean validar(String user, String password){
        return(user.equals("admin") && password.equals("admin"));
    }
}

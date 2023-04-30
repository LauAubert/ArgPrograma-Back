package ArgProgramaBack.Usuario;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.*;


@RestController
public class LoginService {

    private static final String SECRET_KEY = "secret_key";
    private static final ObjectMapper mapper = new ObjectMapper();

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public String validar(@RequestBody JsonNode credenciales) {
        String usuario = credenciales.get("user").asText();
        String password = credenciales.get("password").asText();

        // Aquí iría la validación de las credenciales
        if (!UsuarioDAO.validar(usuario, password)) {
            return mapper.createObjectNode()
                .put("Error", "Credenciales inválidas")
                .toString();
        }

        String token = Jwts.builder()
                .setSubject(usuario)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();

        return mapper.createObjectNode()
                .put("token", token)
                .toString();
    }

    @PostMapping(value = "/validar", consumes = "application/json", produces = "application/json")
    public static boolean validarJwt(@RequestBody JsonNode req) {
        try {
            // Parsear el JWT y verificar la firma
            String jwt = req.get("token").asText();
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwt);
            Claims claims = claimsJws.getBody();
            
            // Si todo es correcto, el JWT es válido
            return claims.getSubject().equals("admin");
        } catch (Exception e) {
            // Si ocurre algún error, el JWT no es válido
            return false;
        }
    }

    public static boolean validarJwt(String jwt) {
        try {
            // Parsear el JWT y verificar la firma
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwt);
            Claims claims = claimsJws.getBody();
            
            // Si todo es correcto, el JWT es válido
            return claims.getSubject().equals("admin");
        } catch (Exception e) {
            // Si ocurre algún error, el JWT no es válido
            return false;
        }
    }
}

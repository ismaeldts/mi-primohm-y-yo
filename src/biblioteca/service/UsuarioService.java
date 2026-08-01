package biblioteca.service;

import biblioteca.model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioService {

    private final List<Usuario> usuarios = new ArrayList<>();

    public boolean guardar(Usuario usuario) {
        if (buscarPorId(usuario.getId()).isPresent()) {
            return false;
        }
        return usuarios.add(usuario);
    }

    public List<Usuario> obtenerTodos() {
        return new ArrayList<>(usuarios);
    }

    public Optional<Usuario> buscarPorId(String id) {
        return usuarios.stream()
                .filter(u -> u.getId().equalsIgnoreCase(id))
                .findFirst();
    }

    public boolean actualizar(String id, Usuario usuarioActualizado) {
        Optional<Usuario> usuarioOpt = buscarPorId(id);
        if (usuarioOpt.isPresent()) {
            Usuario u = usuarioOpt.get();
            u.setNombre(usuarioActualizado.getNombre());
            u.setApellido(usuarioActualizado.getApellido());
            u.setEdad(usuarioActualizado.getEdad());
            u.setBornDate(usuarioActualizado.getBornDate());
            return true;
        }
        return false;
    }

    public boolean eliminar(String id) {
        return usuarios.removeIf(u -> u.getId().equalsIgnoreCase(id));
    }
}
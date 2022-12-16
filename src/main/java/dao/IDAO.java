package dao;

public interface IDAO<T> {
    
    public boolean insertar (T o);
    public boolean borrar (int id);
    public boolean modificar (int id, T nuevo);
    public T consultar (int id);
}

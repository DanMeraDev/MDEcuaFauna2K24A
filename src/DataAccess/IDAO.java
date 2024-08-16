package DataAccess;
import java.util.List;
public interface IDAO<T> {
    public boolean create(T entity) throws Exception;
    public T readByID(int id) throws Exception;
    public boolean update(T entity) throws Exception;
    public boolean delete(int id) throws Exception;
}

import redis.clients.jedis.Jedis;

public class RedisDatabase {
    private Jedis jedis;

    public RedisDatabase() {
        this.jedis = new Jedis("127.0.0.1", 6379);
    }

    // Método para guardar un valor en Redis
    public void setValue(String key, String value) {
        jedis.set(key, value);
    }

    // Método para obtener un valor desde Redis
    public String getValue(String key) {
        return jedis.get(key);
    }

    // Método para verificar si una clave existe en Redis
    public boolean keyExists(String key) {
        return jedis.exists(key);
    }

    // Método para eliminar una clave de Redis
    public void deleteKey(String key) {
        jedis.del(key);
    }

    // Método para cerrar la conexión a Redis
    public void close() {
        jedis.close();
    }
}
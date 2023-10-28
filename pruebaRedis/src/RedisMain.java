import redis.clients.jedis.exceptions.JedisConnectionException;

public class RedisMain {
    public static void main(String[] args) {
        RedisDatabase redisDB = new RedisDatabase();

        try {
            // Set a key-value pair in Redis
            redisDB.setValue("myKey", "Hello, Redis!");

            // Get the value associated with a key
            String retrievedValue = redisDB.getValue("myKey");
            System.out.println("Retrieved value: " + retrievedValue);

            // Check if a key exists
            boolean keyExists = redisDB.keyExists("myKey");
            System.out.println("Key exists: " + keyExists);

            // Delete a key
            redisDB.deleteKey("myKey");
            keyExists = redisDB.keyExists("myKey");
            System.out.println("Key exists after deletion: " + keyExists);
        } catch (JedisConnectionException e) {
            System.err.println("Failed to connect to Redis: " + e.getMessage());
        } finally {
            redisDB.close();
        }
    }

}

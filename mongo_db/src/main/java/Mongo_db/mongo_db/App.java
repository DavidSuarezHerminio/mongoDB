package Mongo_db.mongo_db;

import org.bson.Document;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class App 
{
    public static void main( String[] args )
    {
     String connectionString ="mongodb+srv://davidsuarezelche:CiX2xvjOtxYVqU01@cluster0.ikjpt1q.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
     try(MongoClient mongoClient = MongoClients.create(new ConnectionString(connectionString))){
    	 //obtener la base de datos
    	 MongoDatabase database = mongoClient.getDatabase("Cluster0");
    	 //obtener la coleccion 
    	 MongoCollection<Document> collection = database.getCollection("mi_coleccion");
    	 
    	 //insertar un documento de ejemplo 
    	 Document document = new Document ("nombre", "Ejemplo") .append("edad", 30) .append("ciudad", "EjemploCity");
    	 collection.insertOne(document);
    	 
    	 //consultar e imprimir todos los documentos en la colección
    	 MongoCursor<Document> cursor = collection.find().iterator();
    	 try {
    		 while(cursor.hasNext()) {
    			 System.out.println(cursor.next().toJson());
    		 }
    	 }finally {
    		 cursor.close();
    	 }
    	 
    	 }
    }
}

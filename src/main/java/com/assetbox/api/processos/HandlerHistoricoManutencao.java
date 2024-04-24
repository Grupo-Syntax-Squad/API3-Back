package com.assetbox.api.processos;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class HandlerHistoricoManutencao {
    // Construa a URI de conexão
    String connectionString = "mongodb+srv://assetbox:fatec@cluster0.ycz8pxh.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    ConnectionString connString = new ConnectionString(connectionString);
    
    // Configure as configurações do cliente MongoDB
    MongoClientSettings settings = MongoClientSettings.builder()
            .applyConnectionString(connString)
            .build();
    {
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            // Acesse o banco de dados e a coleção
            MongoDatabase database = mongoClient.getDatabase("assetbox");
            MongoCollection<Document> collection = database.getCollection("historicoman");


            System.out.println("Documento inserido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

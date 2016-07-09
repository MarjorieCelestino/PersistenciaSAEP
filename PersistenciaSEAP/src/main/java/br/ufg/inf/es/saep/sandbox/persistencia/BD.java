/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.es.saep.sandbox.persistencia;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.google.gson.Gson;
import com.mongodb.MongoCommandException;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Marjorie Celestino 
 */
public class BD {
    //Criação do banco de dados e cliente.
    public static MongoClient mongoClient = new MongoClient();;
    public static MongoDatabase database = mongoClient.getDatabase("SEAP");
    
    public static String PARECER = "parecer_collection";
    public static String RADOC = "radoc_collection";
    public static String RESOLUCAO = "resolucao_collection";
    
    public static void makeCollections(){
        try{
            database.createCollection(PARECER);
            database.createCollection(RADOC);
            database.createCollection(RESOLUCAO);
        }catch(MongoCommandException e ){
            System.out.println("Coleções já existem.");
        }
    }
}

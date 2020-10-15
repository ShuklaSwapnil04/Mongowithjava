package studentregister;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

class DBManager {
	public String collectionName= "StudentList";
	MongoClient mongoClient =MongoClients.create();
	Scanner ob=new Scanner(System.in);
	MongoDatabase database= mongoClient.getDatabase("studentRegister");
	MongoCollection<Document> collection =database.getCollection(collectionName);
	Gson gson=new Gson();
	public void saveHashMap(ArrayList<Document> documents)
	{
		if(collection.countDocuments()>0)
		{
			System.out.println("Database has already this collection \n Do you  want to overwrite \n 1.yes \n 2.create a new ");
			int choice=Integer.parseInt(ob.next());
			switch(choice)
			{
			case 1: 
				collection.drop();
				database.createCollection(collectionName);
				collection= database.getCollection(collectionName);
				collection.insertMany(documents);
				break;
			case 2: 
				System.out.println("enter the collection name");
				String NewCollectionName=ob.next();
				database.createCollection(NewCollectionName);
				collection=database.getCollection(NewCollectionName);
				collection.insertMany(documents);
				break;
				default:
					break;
				
		}}
		
		else
		{
			collection.insertMany(documents);
		}
		ob.close();
	}
	public ArrayList<Student> loadHashMap()
	{
		ArrayList<Student> students=new ArrayList<>();
		if(collection.countDocuments() <= 0)
		{
			System.out.println("Collections Empty cannot load");
		}
		else
		{
			MongoCursor<Document> cursor= collection.find().iterator();
			try {
				while(cursor.hasNext())
				{
					students.add(gson.fromJson(cursor.next().toJson(), Student.class));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				cursor.close();
			}
		}
		return students;
	}

}

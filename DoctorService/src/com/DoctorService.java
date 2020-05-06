package com;

import model.Doctor;
//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Doctor")
public class DoctorService {
	Doctor ItemObj = new Doctor();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems() {
		return ItemObj.readItems();
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertItem(@FormParam("itemCode") String itemCode, @FormParam("itemName") String itemName,
			@FormParam("itemPrice") String itemPrice, @FormParam("itemDesc") String itemDesc) {
		String output = ItemObj.insertItem(itemCode, itemName, itemPrice, itemDesc);
		return output;
	}
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateItem(String itemData) {
		// Convert the input string to a JSON object
		JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject();
		// Read the values from the JSON object
		String itemID = itemObject.get("itemID").getAsString();
		String itemCode = itemObject.get("itemCode").getAsString();
		String itemName = itemObject.get("itemName").getAsString();
		String itemPrice = itemObject.get("itemPrice").getAsString();
		String itemDesc = itemObject.get("itemDesc").getAsString();
		String output = ItemObj.updateItem(itemID, itemCode, itemName, itemPrice, itemDesc);
		return output;
	}
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem(String itemData) {
		Document doc = Jsoup.parse(itemData, "", Parser.xmlParser());
		String itemID = doc.select("itemID").text();
		String output = ItemObj.deleteItem(itemID);
		return output;
	}
}

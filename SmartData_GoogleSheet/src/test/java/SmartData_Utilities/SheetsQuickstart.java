package SmartData_Utilities;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.BSONException;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

public class SheetsQuickstart {
	private static final String APPLICATION_NAME = "SmartTicketUpgrade";
	private static final java.io.File DATA_STORE_DIR = new java.io.File(
			System.getProperty("user.home"),
			".credentials/sheets.googleapis.com-java-quickstart.json");
	private static FileDataStoreFactory DATA_STORE_FACTORY;
	private static final JsonFactory JSON_FACTORY = JacksonFactory
			.getDefaultInstance();
	private static HttpTransport HTTP_TRANSPORT;
	
	private static final List<String> SCOPES = Arrays.asList(
			SheetsScopes.SPREADSHEETS, SheetsScopes.DRIVE);

	static {
		try {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
		} catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}
	}
	
	public static Credential authorize() throws IOException 
	{
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
				HTTP_TRANSPORT, JSON_FACTORY, SheetsQuickstart.getClientSecret(), SCOPES)
				.setDataStoreFactory(DATA_STORE_FACTORY)
				.setAccessType("offline").build();
		Credential credential = new AuthorizationCodeInstalledApp(flow,
				new LocalServerReceiver()).authorize("user");
		System.out.println("Credentials saved to "
				+ DATA_STORE_DIR.getAbsolutePath());
		return credential;
	}
	private static GoogleClientSecrets getClientSecret() throws IOException
	{	
				InputStream in = SheetsQuickstart.class
						.getResourceAsStream("D:\\Credentials\\client_secret.json");
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
				JSON_FACTORY, new InputStreamReader(in));
		return clientSecrets;
	}
	public static Sheets getSheetsService() throws IOException 
	{
		Credential credential = authorize();
		return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
				.setApplicationName(APPLICATION_NAME).build();
	}


	public static void main(String[] args) throws IOException, BSONException
	{
	        Sheets service = getSheetsService();
	        String spreadsheetId = "1WcD-vJXI2z4wZ9TQ1tHiT8cmmrKgD8v3cqKB-cPctRo";
	        String range = "SmartData!A7:E13";


   List<List<Object>> arrData = getData();

	        ValueRange oRange = new ValueRange();
	        oRange.setRange(range); // I NEED THE NUMBER OF THE LAST ROW
	        oRange.setValues(arrData);

	        List<ValueRange> oList = new ArrayList<>();
	        oList.add(oRange);

	        BatchUpdateValuesRequest oRequest = new BatchUpdateValuesRequest();
	        oRequest.setValueInputOption("RAW");
	        oRequest.setData(oList);

	        BatchUpdateValuesResponse oResp1 = service.spreadsheets().values().batchUpdate(spreadsheetId, oRequest).execute();
	   }

	public static List<List<Object>> getData() {

		List<Object> data1 = new ArrayList<Object>();
		data1.add("jagadeesh");
		data1.add("jagadeesh");
		data1.add("jagadeesh");

		List<Object> data2 = new ArrayList<Object>();
		data2.add("jagadeesh");
		data2.add("jagadeesh");
		data2.add("jagadeesh");

		List<List<Object>> data = new ArrayList<List<Object>>();
		data.add(data1);
		data.add(data2);

		return data;
	}

	
	
	
}

package com.bayram.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MusteriRESTfulClient {
	
	public static void main(String[] args) {
		
		URL url;
		try {
			url = new URL("http://localhost:8090/RestfulMultipleOutputFormalJDBC/rest/musteri/liste");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

				String output;
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}

				conn.disconnect();
		
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

	}

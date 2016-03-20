package ms.sms.util;


import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class HTTPUtil
{
	public static String httppost( String link, String xml) throws Exception
	{
		HttpClient httpclient = new DefaultHttpClient();
		
		try {
			HttpPost httppost = new HttpPost( link );
			httppost.setHeader( "Content-type", "text/xml; charset=UTF-8" );
			httppost.setEntity( new StringEntity( xml, HTTP.UTF_8 ) );
			
			HttpResponse response = httpclient.execute( httppost );
			int status = response.getStatusLine().getStatusCode();
			if ( status != HttpStatus.SC_OK ) {
				throw new RuntimeException( link + " httppost failed... - " + response.getStatusLine() );
			}
			HttpEntity entity = response.getEntity();
			if ( entity != null ) {
				return EntityUtils.toString( entity );
			}
			return null;
		} catch ( IOException ex ) {
			System.out.println( "HttpPost IO EXCEPTION xml: " + xml + " EX: " + ex );
			throw new RuntimeException( ex );
		} catch ( RuntimeException ex ) {
			System.out.println( "HttpPost RUNTIME EXCEPTION xml: " + xml + ex );
			throw ex;
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
	}
}

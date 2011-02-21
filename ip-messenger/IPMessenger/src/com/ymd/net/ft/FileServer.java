/**
 * 
 */
package com.ymd.net.ft;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.ymd.log.IPMLogger;
import com.ymd.util.Constants;

/**
 * This is the server which handles File transfers.
 * 
 * @author yaragalla Muralidhar.
 *
 */
public class FileServer implements Runnable{
	
	private IPMLogger logger=IPMLogger.getLogger();

	@Override
	public void run() {
		try{
			ServerSocket fileServer=new ServerSocket(Constants.FILE_SERVER_PORT);
			while(true){
				Socket fileSocket=fileServer.accept();
				Thread thread=new Thread(new FileSocketHandler(fileSocket));
				thread.start();
			}
		}catch(IOException ioe){
			logger.error(ioe.getMessage(), ioe);
		}		
	}	
}

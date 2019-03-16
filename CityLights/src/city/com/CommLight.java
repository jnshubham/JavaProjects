package city.com;
import java.io.*;
import java.util.*;
import javax.comm.*;

public class CommLight {
    static CommPortIdentifier portId;

//write information to device
OutputStream outputStream;


    SerialPort serialPort;


   public void sendMessage(String C)
    {try{
		outputStream.write(C.getBytes());
       }catch(Exception e){}
		}

  public   CommLight(String comPort)
        {
         		  try {

		portId = CommPortIdentifier.getPortIdentifier(comPort);
	  	serialPort = (SerialPort) portId.open("CommLight", 2000);
				        } catch (Exception e) {System.out.println(e);}
	try {
	outputStream = serialPort.getOutputStream();
			} catch (IOException e) {System.out.println(e);}
				          try {
serialPort.setSerialPortParams(9600,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
	  } catch (UnsupportedCommOperationException e) {System.out.println(e);}

        }

public void close()
{try {
	outputStream.close();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	serialPort.close();
	}

}
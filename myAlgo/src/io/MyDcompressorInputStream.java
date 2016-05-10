package io;

import java.io.IOException;
import java.io.InputStream;

public class MyDcompressorInputStream extends InputStream{
	
	InputStream in;
	
	public MyDcompressorInputStream(InputStream in) {
		this.in = in;
	}
	

	@Override
	public int read() throws IOException {
	
		return in.read();
	
	}
	
	@Override
	public int read(byte[] b) throws IOException {
		byte lastbyte;
		byte count;
		
		lastbyte=(byte)in.read();
		count=(byte)in.read();
		
		for(int i=0;i<b.length;i++)
		{
			if(count!= 0)
			{
				count--;
				b[i]=lastbyte;
			}
			else
			{
				lastbyte=(byte)in.read();
				count=(byte)in.read();
				count--;
				b[i]=lastbyte;
			}
			
		}
		
		return 0;
	}

}

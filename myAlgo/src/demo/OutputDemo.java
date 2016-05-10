package demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import io.MyCompressorOutputStream;
import io.MyDcompressorInputStream;
import mazeGenerators.Maze3d;
import mazeGenerators.MyMaze3dGenerator;

public class OutputDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Maze3d mymaze = new MyMaze3dGenerator().generate(5, 6, 5);
		
		try {
			
			OutputStream out = new MyCompressorOutputStream(new FileOutputStream("1.maz"));
			out.write(mymaze.toByteArray());
			out.flush();
			out.close();
			
			System.out.println(mymaze);
			System.out.println("Should be saved as:");
			byte[] b2 = mymaze.toByteArray();
			for (byte bb : b2) {
				System.out.print(bb);
			}

			
			System.out.println("");
			
		
			
//			OutputStream out2 = new FileOutputStream("2.maz");
//			out2.write(mymaze.toByteArray());
//			out2.flush();
//			out2.close();
			
			InputStream in= new MyDcompressorInputStream(new FileInputStream("1.maz"));
			byte[] b= new byte[mymaze.getZ()*mymaze.getX()*mymaze.getY()];
			in.read(b);
			in.close();
			for(int i =0;i<b.length;i++)
			System.out.print(b[i]);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

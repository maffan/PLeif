package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FilesRW
{
	/**
	 * Serializes object and save to file.
	 * @param t Object to save
	 * @param fileName File to save to
	 */
	public static <T> void saveTo(T t, String fileName)
	{
	        try {
				ObjectOutputStream out = 
				        new ObjectOutputStream(
				                new FileOutputStream(fileName));
				out.writeObject(t);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	/**
	 * Deserializes file and returns the object.
	 * @param fileName File to load from
	 * @return Loaded object
	 */
	@SuppressWarnings("unchecked")
	public static <T> T loadFrom(String fileName)
	{
	    T object = null;

	    try {
			ObjectInputStream in = 
			        new ObjectInputStream(
			                new FileInputStream(fileName));
			object = (T)in.readObject();
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	    return (T)object;
	}
}


/* This file has been generated by Stubmaker (de.uka.ilkd.stubmaker)
 * Date: Tue Apr 15 10:18:20 CEST 2008
 */
package java.io;

public abstract class InputStream extends java.lang.Object implements java.io.Closeable
{

   public InputStream();
   public abstract int read() throws java.io.IOException;
   public int read(byte[] arg0) throws java.io.IOException;
   public int read(byte[] arg0, int arg1, int arg2) throws java.io.IOException;
   public long skip(long arg0) throws java.io.IOException;
   public int available() throws java.io.IOException;
   public void close() throws java.io.IOException;
   public void mark(int arg0);
   public void reset() throws java.io.IOException;
   public boolean markSupported();
}

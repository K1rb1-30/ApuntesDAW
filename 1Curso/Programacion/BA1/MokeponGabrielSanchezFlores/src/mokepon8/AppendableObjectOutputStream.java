package mokepon8;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class AppendableObjectOutputStream extends ObjectOutputStream{
	private boolean append;
    private boolean initialized;
    private DataOutputStream dout;
    public AppendableObjectOutputStream(FileOutputStream out, boolean append) throws IOException {
        super(out);
        this.dout = new DataOutputStream(out);
	  this.append = append;
	  this.initialized = (out.getChannel().position()!=0)?true:false;
        this.writeStreamHeader();

	 
    }
    @Override
    protected void writeStreamHeader() throws IOException {
        if (this.initialized && this.append){
            this.reset();
            return;
        }
        if (dout != null) {
            dout.writeShort(STREAM_MAGIC);
            dout.writeShort(STREAM_VERSION);
        }
    }
}

package Classes;

import Interfaces.Reader;
import Interfaces.Writer;

class IOManager implements Reader, Writer {
    private final Reader rd;
    private final Writer wr;
    private final MessageBox mb;
    IOManager(Reader rd, Writer wr){
        this.rd = rd;
        this.wr = wr;
        this.mb = new MessageBox();
    }
    public String read(){
        wr.write(mb.getInputMessage());
        String mes = rd.read();
        wr.writeln(mes);
        return mes;
    }
    public void write(String m){
        wr.write(m);
    }
    public void writeln(String m){
        wr.writeln(m);
    }
}

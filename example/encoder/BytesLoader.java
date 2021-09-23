package example.encoder;

public class BytesLoader extends ClassLoader {

    private byte[] bytes;

    public BytesLoader(ClassLoader parent, byte[] bytes) {
        super(parent);

        this.bytes = bytes;
    }

    public Class findClass(String name) {
        return defineClass(name, bytes, 0, bytes.length);
    }

}

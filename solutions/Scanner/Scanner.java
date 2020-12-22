import java.io.*;
import java.util.*;

public class Scanner {
	private int chr;
	public BufferedReader reader;
	private boolean de = false;

	public Scanner(String a) {
		// a = a + " ";
		this.reader = new BufferedReader(new StringReader(a));
	}
	public Scanner(StringBuffer a) {
		// a.append(" ");
		this.reader = new BufferedReader(new StringReader(a.toString()));
	}
	public Scanner(InputStream a) {
		this.reader = new BufferedReader(new InputStreamReader(a));
	}

	public boolean hasNextInt() {
		try {
			this.reader.mark(32);
			char ch = (char) chr;
			while (this.chr != -1) {
				if (Character.isDigit(ch) || ch == '-') {
					this.reader.reset();
					return true;
				}
				this.chr = reader.read();
				ch = (char) chr;
			}
			this.reader.reset();
		} catch(IOException e) {
			System.err.println("Error occured while trying parse Int" + e.getMessage());
		}
		return false;
	}

	public int nextInt() {
		StringBuffer sb = new StringBuffer();
		try {
			this.chr = reader.read();
			char ch = (char) chr;
			while (this.chr != -1) {
				if (sb.length() != 0 && !(Character.isDigit(ch) || ch == '-')) {
					return Integer.parseInt(sb.toString());
				}
				if (Character.isDigit(ch) || ch == '-') {
					sb.append((char) chr);
				}
				this.chr = reader.read();
				ch = (char) chr;
			}
		} catch(IOException e) {
			System.err.println("Error occured while trying parse Int" + e.getMessage());
		}
		return Integer.parseInt(sb.toString());
	}

	public boolean hasNextAbc() {
		try {
			this.reader.mark(32);
			char ch = (char) chr;
			while (this.chr != -1) {
				if (Character.isDigit(ch) || ch == '-' || 'a' <= ch && ch <= 'z') {
					this.reader.reset();
					return true;
				}
				this.chr = reader.read();
				ch = (char) chr;
			}
			this.reader.reset();
		} catch(IOException e) {
			System.err.println("Error occured while trying parse ABC" + e.getMessage());
		}
		return false;
	}

	public String nextAbc() {
		StringBuffer sb = new StringBuffer();
		try {
			this.chr = reader.read();
			char ch = (char) chr;
			while (this.chr != -1) {
				if (sb.length() != 0 && !(Character.isDigit(ch) || ch == '-') && !('a' <= ch && ch <='z' || this.chr == 45)) {
					return sb.toString();
				}
				if (Character.isDigit(ch)) {
					sb.append(ch);
				}
				if ('a' <= ch && ch <='z') {
					sb.append((char) chr);
				}
				if (ch == '-') {
					if (sb.length() == 0) {
						sb.append('-');
					}
				}
				this.chr = reader.read();
				ch = (char) chr;
			}
		} catch(IOException e) {
			System.err.println("Error occured while trying parse ABC" + e.getMessage());
		}
		return sb.toString();
	}

	public boolean hasNextLine() {
		try {
			if (de == false) {
				de = true;
				return de;
			}
			this.reader.mark(32);
			while (this.chr != -1) {
				if (this.chr == 10 || this.chr == 13) {
					this.reader.reset();
					return true;
				}
				this.chr = reader.read();
			}
			this.reader.reset();
		} catch(IOException e) {
			System.err.println("Error occured while trying parse Line" + e.getMessage());
		}
		return false;

	}

	public StringBuffer nextLine() {
		StringBuffer sb = new StringBuffer();
		try {
			this.chr = reader.read();
			while (this.chr != -1) {
				if (this.chr == 10 || this.chr == 13) {
					return sb;
				}
				sb.append((char)this.chr);
				this.chr = reader.read();
			}
		} catch(IOException e) {
			System.err.println("Error occured while trying parse Line" + e.getMessage());
		}
		return sb;
	}
}
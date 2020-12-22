import java.io.*;
import java.util.*;

public class Scanner {
	private int chr;
	public BufferedReader reader;
	private boolean de = false;
	public boolean per = true;

	public Scanner(String a) {
		this.reader = new BufferedReader(new StringReader(a));
	}
	public Scanner(StringBuffer a) {
		this.reader = new BufferedReader(new StringReader(a.toString()));
	}
	public Scanner(InputStream a) {
		this.reader = new BufferedReader(new InputStreamReader(a));
	}
	public Scanner(String a, String b) {
		try {
			this.reader = new BufferedReader(new InputStreamReader(new FileInputStream(a),b));
		} catch (IOException e) {
			System.err.println("Error occured while trying " + e.getMessage());
		}
	}
	

	public boolean hasNext() {
		try {
			this.reader.mark(1024);
			while (this.chr != -1) {
				this.chr = reader.read();
				if (this.chr == 10 || this.chr == 13){
					this.per = true;
				}
				if (!Character.isSpaceChar((char) chr)) {
					this.reader.reset();
					this.per = false;
					return true;
				}
			}
		} catch(IOException e) {
			System.err.println("Error occured while trying to parse next item" + e.getMessage());
		}
		return false;
	}
	public boolean hasNextInt() {
		try {
			this.reader.mark(1024);
			while (this.chr != -1) {
				if (47 < this.chr && this.chr < 58 || this.chr == 45) {
					this.reader.reset();
					return true;
				}
				this.chr = reader.read();
			}
			this.reader.reset();
		} catch(IOException e) {
			System.err.println("Error occured while trying to parse next int" + e.getMessage());
		}
		return false;
	}

	public int nextInt() {
		StringBuffer sb = new StringBuffer();
		try {
			this.chr = reader.read();
			while (this.chr != -1) {
				if (sb.length() != 0 && !(47 < this.chr  && this.chr < 58 || this.chr == 45)) {
					return Integer.parseInt(sb.toString());
				}
				if (47 < this.chr && this.chr < 58 || this.chr == 45) {
					sb.append((char) chr);
				}
				this.chr = reader.read();
			}
		} catch(IOException e) {
			System.err.println("Error occured while trying parse next int" + e.getMessage());
		}
		return Integer.parseInt(sb.toString());
	}

	public boolean hasNextAbc() {
		try {
			this.reader.mark(1024);
			while (this.chr != -1) {
				if (47 < this.chr && this.chr < 58 || this.chr == 45 || 96 < this.chr && this.chr < 124) {
					this.reader.reset();
					return true;
				}
				this.chr = reader.read();
			}
			this.reader.reset();
		} catch(IOException e) {
			System.err.println("Error occured while trying parse nextAbc" + e.getMessage());
		}
		return false;
	}

	public String nextAbc() {
		StringBuffer sb = new StringBuffer();
		try {
			this.chr = reader.read();
			while (this.chr != -1) {
				if (sb.length() != 0 && !(47 < this.chr  && this.chr < 58 || this.chr == 45) && !(96 < this.chr && this.chr < 124 || this.chr == 45)) {
					return sb.toString();
				}
				if (47 < this.chr && this.chr < 58) {
					sb.append((char) chr);
				}
				if (96 < this.chr && this.chr < 124) {
					sb.append((char) chr);
				}
				if (this.chr == 45) {
					if (sb.length() == 0) {
						sb.append('-');
					}
				}
				this.chr = reader.read();
			}
		} catch(IOException e) {
			System.err.println("Error occured while trying parse nextAbc" + e.getMessage());
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
			System.err.println("Error occured while trying to parse next line" + e.getMessage());
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
			System.err.println("Error occured while trying to parse next line" + e.getMessage());
		}
		return sb;
	}

	public String nextWord() {
		StringBuffer sb = new StringBuffer();
		char ch;
		try {
			this.chr = reader.read();
			while (this.chr != -1) {
				ch =(char) this.chr;
				if (Character.isAlphabetic(ch) ||  Character.getType(ch) == 20 || ch == '\'') {
					sb.append(ch);
				} else if (sb.length() > 0 ) {
					return sb.toString();
				}
				this.chr = reader.read();
			}
		} catch(IOException e) {
			System.err.println("Error occured while trying parse next word" + e.getMessage());
		}
		return sb.toString();
	}

	public void close() {
		try {
			reader.close();
		} catch (IOException e) {
			System.err.println("Error occured while trying to close scanner" + e.getMessage());
		}
	}
}
package HillCipher;
import java.util.Scanner;
public class Hill {
	    private static Scanner in;
	    public static void main(String[] args){
	        in = new Scanner(System.in);

	        System.out.print("1. Encryption\n2. Decryption\n 3.Rail Encryption\n 4.Rail Decryption\nChoose(1,2,3,4): ");
	        int choice = in.nextInt();
	        in.nextLine();

	        if(choice == 1){
	            System.out.println("---Encryption---");
	            cipherEncryption();
	        } else if (choice == 2){
	            System.out.println("---Decryption---");
	            cipherDecryption();
	        } 
	        else if(choice == 3){
	        	System.out.println("---Rail Encryption---");
	        	railEncryption();
	        }
	        else if(choice == 4){
	        	System.out.println("---Rail Decryption---");
	        	railDecryption();
	        }else {
	            System.out.println("Invalid Choice");
	        }
	    }

	    private static void cipherDecryption() {
	        System.out.print("Enter message: "); 
	        String msg = in.nextLine();
	        msg = msg.replaceAll("\\s" , "");
	        msg = msg.toUpperCase();

	        // if irregular length, then perform padding
	        int lenChk = 0;
	        if (msg.length() % 2 != 0){
	            msg += "0";
	            lenChk = 1;
	        }

	        // message to matrices
	        int[][] msg2D = new int[2][msg.length()];
	        int itr1 = 0;
	        int itr2 = 0;
	        for (int i = 0; i < msg.length(); i++){
	            if (i%2 == 0){
	                msg2D[0][itr1] = ((int)msg.charAt(i)) - 65;
	                itr1++;
	            } else {
	                msg2D[1][itr2] = ((int)msg.charAt(i)) - 65;
	                itr2++;
	            } // if-else
	        } // for

	        System.out.print("Enter 4 letter key string: ");
	        String key = in.nextLine();
	        key = key.replaceAll("\\s","");
	        key = key.toUpperCase();

	        // key to 2x2 matrix
	        int[][] key2D = new int[2][2];
	        int itr3 = 0;
	        for (int i = 0; i < 2; i++) {
	            for (int j = 0; j < 2; j++) {
	                key2D[i][j] = (int)key.charAt(itr3)-65;
	                itr3++;
	            }
	        }

	        // validating the key
	        // finding determinant of key matrix
	        int deter = key2D[0][0] * key2D[1][1] - key2D[0][1] * key2D[1][0];
	        deter = moduloFunc(deter, 26);

	        // multiplicative inverse of key matrix
	        int mulInverse = -1;
	        for (int i = 0; i < 26; i++) {
	            int tempInv = deter * i;
	            if (moduloFunc(tempInv, 26) == 1){
	                mulInverse = i;
	                break;
	            } else {
	                continue;
	            } // if-else
	        } // for

	        // adjugate matrix
	        // swapping
	        int swapTemp = key2D[0][0];
	        key2D[0][0] = key2D[1][1];
	        key2D[1][1] = swapTemp;

	        // changing signs
	        key2D[0][1] *= -1;
	        key2D[1][0] *= -1;

	        key2D[0][1] = moduloFunc(key2D[0][1], 26);
	        key2D[1][0] = moduloFunc(key2D[1][0], 26);

	        // multiplying multiplicative inverse with adjugate matrix
	        for (int i = 0; i < 2; i++) {
	            for (int j = 0; j < 2; j++) {
	                key2D[i][j] *= mulInverse;
	            }
	        }
	        for (int i = 0; i < 2; i++) {
	            for (int j = 0; j < 2; j++) {
	                key2D[i][j] = moduloFunc(key2D[i][j], 26);
	            }
	        }

	        String decrypText = "";
	        int itrCount = msg.length() / 2;
	        if (lenChk == 0){
	            // if msg length % 2 = 0
	            for (int i = 0; i < itrCount; i++) {
	                int temp1 = msg2D[0][i] * key2D[0][0] + msg2D[1][i] * key2D[0][1];
	                decrypText += (char)((temp1 % 26) + 65);
	                int temp2 = msg2D[0][i] * key2D[1][0] + msg2D[1][i] * key2D[1][1];
	                decrypText += (char)((temp2 % 26) + 65);
	            }
	        } else {
	            // if msg length % 2 != 0 (irregular length msg)
	            for (int i = 0; i < itrCount-1; i++) {
	                int temp1 = msg2D[0][i] * key2D[0][0] + msg2D[1][i] * key2D[0][1];
	                decrypText += (char)((temp1 % 26) + 65);
	                int temp2 = msg2D[0][i] * key2D[1][0] + msg2D[1][i] * key2D[1][1];
	                decrypText += (char)((temp2 % 26) + 65);
	            }
	        }

	        System.out.println("Decrypted Text: " + decrypText);


	    }

	    private static void cipherEncryption() {
	        System.out.print("Enter message: ");
	        String msg = in.nextLine();
	        msg = msg.replaceAll("\\s" , "");
	        msg = msg.toUpperCase();

	        // if irregular length, then perform padding
	        int lenChk = 0;
	        if (msg.length() % 2 != 0){
	            msg += "0";
	            lenChk = 1;
	        }

	        // message to matrices
	        int[][] msg2D = new int[2][msg.length()];
	        int itr1 = 0;
	        int itr2 = 0;
	        for (int i = 0; i < msg.length(); i++){
	            if (i%2 == 0){
	                msg2D[0][itr1] = ((int)msg.charAt(i)) - 65;
	                itr1++;
	            } else {
	                msg2D[1][itr2] = ((int)msg.charAt(i)) - 65;
	                itr2++;
	            } // if-else
	        } // for

//	        // testing 2D matrix
//	        for (int i = 0; i < 2; i++) {
//	            for (int j = 0; j < msg.length() / 2; j++) {
//	                System.out.print((char)(msg2D[i][j]+65) + " ");
//	            }
//	            System.out.println();
//	        }

	        System.out.print("Enter 4 letter key string: ");
	        String key = in.nextLine();
	        key = key.replaceAll("\\s","");
	        key = key.toUpperCase();

	        // key to 2x2 matrix
	        int[][] key2D = new int[2][2];
	        int itr3 = 0;
	        for (int i = 0; i < 2; i++) {
	            for (int j = 0; j < 2; j++) {
	                key2D[i][j] = (int)key.charAt(itr3)-65;
	                itr3++;
	            }
	        }

	        // validating the key
	        // finding determinant of key matrix
	        int deter = key2D[0][0] * key2D[1][1] - key2D[0][1] * key2D[1][0];
	        deter = moduloFunc(deter, 26);

	        // multiplicative inverse of key matrix
	        int mulInverse = -1;
	        for (int i = 0; i < 26; i++) {
	            int tempInv = deter * i;
	            if (moduloFunc(tempInv, 26) == 1){
	                mulInverse = i;
	                break;
	            } else {
	                continue;
	            } // if-else
	        } // for

	        if (mulInverse == -1){
	            System.out.println("invalid key");
	            System.exit(1);
	        }

	        String encrypText = "";
	        int itrCount = msg.length() / 2;
	        if (lenChk == 0){
	            // if msg length % 2 = 0
	            for (int i = 0; i < itrCount; i++) {
	                int temp1 = msg2D[0][i] * key2D[0][0] + msg2D[1][i] * key2D[0][1];
	                encrypText += (char)((temp1 % 26) + 65);
	                int temp2 = msg2D[0][i] * key2D[1][0] + msg2D[1][i] * key2D[1][1];
	                encrypText += (char)((temp2 % 26) + 65);
	            }
	        } else {
	            // if msg length % 2 != 0 (irregular length msg)
	            for (int i = 0; i < itrCount-1; i++) {
	                int temp1 = msg2D[0][i] * key2D[0][0] + msg2D[1][i] * key2D[0][1];
	                encrypText += (char)((temp1 % 26) + 65);
	                int temp2 = msg2D[0][i] * key2D[1][0] + msg2D[1][i] * key2D[1][1];
	                encrypText += (char)((temp2 % 26) + 65);
	            }
	        }

	        System.out.println("Encrypted Text: " + encrypText);

	    }

	    // modulo function
	    public static int moduloFunc(int a, int b){
	        int result = a % b;
	        if (result < 0){
	            result += b;
	        }
	        return result;
	    }
	    private static void railDecryption() {
	        System.out.print("Enter message: ");
	        String message = in.nextLine();
	        // removing white space from message
	        message = message.replaceAll("\\s","");
	        in.nextLine();

	        System.out.print("Enter key(number of rails): ");
	        int key = in.nextInt();
	        in.nextLine();

	        char[][] rail = new char[key][message.length()];
	        // matrix
	        for (int i = 0; i < key; i++){
	            for (int j = 0; j < message.length(); j++) {
	                rail[i][j] = '.';
	            }
	        } // for

	        // putting letters in the matrix in zig-zag
	        int row = 0;
	        int check = 0;
	        for (int i = 0; i < message.length(); i++) {
	            if (check == 0){
	                rail[row][i] = message.charAt(i);
	                row++;
	                if (row == key){
	                    check = 1;
	                    row--;
	                }
	            } else if(check == 1){
	                row--;
	                rail[row][i] = message.charAt(i);
	                if (row == 0){
	                    check = 0;
	                    row = 1;
	                }
	            } // if-else
	        } // for

	        // changing order of rails
	        int ordr = 0;
	        for (int i = 0; i < key; i++) {
	            for (int j = 0; j < message.length(); j++) {
	                String temp = rail[i][j] + "";
	                if (temp.matches("\\.")){
	                    // skipping in case of '.'
	                    continue;
	                } else {
	                    // adding cipher letters one by one diagonally
	                    rail[i][j] = message.charAt(ordr);
	                    ordr++;
	                } // if-else
	            } // inner for
	        } // for

	        // checking message reorder on rails
	        System.out.println("Reorder");
	        for (int i = 0; i < key; i++) {
	            for (int j = 0; j < message.length(); j++) {
	                System.out.print(rail[i][j]);
	            }
	            System.out.println();
	        }

	        String decrypText = "";
	        check = 0;
	        row = 0;
	        // converting rails back into a single line message
	        for (int i = 0; i < message.length(); i++) {
	            if (check == 0){
	                decrypText += rail[row][i];
	                row++;
	                if(row == key){
	                    check = 1;
	                    row--;
	                }
	            } else if (check == 1){
	                row--;
	                decrypText += rail[row][i];
	                if(row == 0){
	                    check = 0;
	                    row = 1;
	                }
	            } // if-else
	        } // for

	        System.out.println("Decrypted Text: " + decrypText);


	    }

	    private static void railEncryption() {
	        System.out.print("Enter message: ");
	        String message = in.nextLine();
	        // removing white space from message
	        message = message.replaceAll("\\s","");
	        in.nextLine();

	        System.out.print("Enter key(number of rails): ");
	        int key = in.nextInt();
	        in.nextLine();

	        char[][] rail = new char[key][message.length()];
	        // matrix
	        for (int i = 0; i < key; i++){
	            for (int j = 0; j < message.length(); j++) {
	                rail[i][j] = '.';
	            }
	        } 
	        // putting letters in the matrix in zig-zag
	        int row = 0;
	        int check = 0;
	        for (int i = 0; i < message.length(); i++) {
	            if (check == 0){
	                rail[row][i] = message.charAt(i);
	                row++;
	                if (row == key){
	                    check = 1;
	                    row--;
	                }
	            } else if(check == 1){
	                row--;
	                rail[row][i] = message.charAt(i);
	                if (row == 0){
	                    check = 0;
	                    row = 1;
	                }
	            } // if-else
	        } // for

	        String encrypText = "";
	        for (int i = 0; i < key; i++) {
	            for (int j = 0; j < message.length(); j++) {
	                encrypText += rail[i][j];

	            }
	        }

	        encrypText = encrypText.replaceAll("\\.","");
	        System.out.println("Encrypted Message: " + encrypText);
	    }

	}


